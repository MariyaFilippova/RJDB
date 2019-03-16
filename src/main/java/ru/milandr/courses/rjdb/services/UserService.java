package ru.milandr.courses.rjdb.services;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import ru.milandr.courses.rjdb.daos.UserDao;
import ru.milandr.courses.rjdb.dtos.ResumeDto;
import ru.milandr.courses.rjdb.dtos.UserDto;
import ru.milandr.courses.rjdb.entities.Resume;
import ru.milandr.courses.rjdb.entities.User;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Service

public class UserService

{
    private UserDao userDao;
    public UserService(UserDao userDao)
    {
        this.userDao = userDao;
    }
    public UserDto getUser(long userId)
{
    User user = userDao.findOne(userId);
    return buildUserDtoFromUser(user);
}

    private UserDto buildUserDtoFromUser(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPhoto(user.getPhoto());
        userDto.setMobile_phone(user.getMobile_phone());
        userDto.setResumes(buildResumeDtoListFromResumeList(user.getResumes()));

        return userDto;
    }
    private List<ResumeDto> buildResumeDtoListFromResumeList(List<Resume> resumes) {
        return resumes.stream()
                .map(resume -> new ResumeDto(resume.getId(),  resume.getName(), resume.getResume(), resume.getStatus().getValue(),resume.getAreaId(), resume.getUserId()))
                .collect(Collectors.toList());
    }


}
