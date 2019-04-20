package ru.milandr.courses.rjdb.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.milandr.courses.rjdb.dtos.UserDto;
import ru.milandr.courses.rjdb.services.UserService;

import javax.validation.ValidationException;

@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) throws ValidationException {
        userService.createUser(userDto);
    }


}

