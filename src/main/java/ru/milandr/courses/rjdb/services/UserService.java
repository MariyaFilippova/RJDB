package ru.milandr.courses.rjdb.services;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.common.PasswordUtils;
import ru.milandr.courses.rjdb.common.ValidationException;
import ru.milandr.courses.rjdb.common.ValidationUtils;
import ru.milandr.courses.rjdb.daos.UserDao;
import ru.milandr.courses.rjdb.dtos.UserDto;
import ru.milandr.courses.rjdb.dtos.UserPostDto;
import ru.milandr.courses.rjdb.entities.User;

import static ru.milandr.courses.rjdb.common.ValidationUtils.validateIsNotNull;


@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserDao userDao;

    // Transactional Нужна, если мы используем не контроллер, а достаем бин из контекста
    // без транзакции маппинги сущностей работать не будут. В данном случае
    // будет LazyInitializationException - orders не проинициализируется
    // @Transactional
    // При доступе из контроллера же неявно откроется транзакция на уровне запроса
    public UserDto get(Long userId) throws ValidationException {
        validateIsNotNull(userId, "No User id provided");

        User user = userDao.findOne(userId);
        validateIsNotNull(user, "No User with id " + userId);

        return buildUserDtoFromUser(user);
    }



    private UserDto buildUserDtoFromUser(User user) {
        return new UserDto(user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPhoto());
    }

    public User create(UserPostDto userPostDto) throws ValidationException {
        ValidationUtils.validateIsNotNull(userPostDto, "No user provided to proceed");

        User user = buildUserFromUserPostDto(userPostDto);
        ValidationUtils.validateIsNotNull(user, "Can non handle request properly");

        User dbUser = userDao.findByName(user.getName());
        ValidationUtils.validateIsNull(dbUser, "User name is already in use");
        dbUser = userDao.findByEmail(user.getEmail());
        ValidationUtils.validateIsNull(dbUser, "User e-mail is already in use");

        return userDao.save(user);
    }

    private User buildUserFromUserPostDto(UserPostDto userPostDto) {
        User user = new User();
        user.setEmail(userPostDto.getEmail());
        user.setName(userPostDto.getName());

        try {
            String salt = PasswordUtils.getNewSalt();
            String passwordHash = PasswordUtils.getPasswordHash(userPostDto.getPassword(), salt);

            user.setPasswordSalt(salt);
            user.setPasswordHash(passwordHash);
            return user;
        } catch (Exception e) {
            log.error("An exception occurred during salt generation");
            return null;
        }
    }

    public long getCurrentAuthenticatedUserIdSafely() throws ValidationException {
        User currentAuthenticatedUser = getCurrentAuthenticatedUser();
        ValidationUtils.validateIsNotNull(currentAuthenticatedUser, "Current user is not presented");

        return currentAuthenticatedUser.getId();
    }

    public User getCurrentAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }

        String currentPrincipalName = authentication.getName();
        if (currentPrincipalName == null) {
            return null;
        }

        return userDao.findByName(currentPrincipalName);
    }

    public UserDto getCurrent() throws ValidationException {
        User currentUser = getCurrentAuthenticatedUser();
        ValidationUtils.validateIsNotNull(currentUser, "No current user");

        return buildUserDtoFromUser(currentUser);
    }
}