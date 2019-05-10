package ru.milandr.courses.rjdb.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.milandr.courses.rjdb.common.ValidationException;
import ru.milandr.courses.rjdb.dtos.UserDto;
import ru.milandr.courses.rjdb.dtos.UserPostDto;
import ru.milandr.courses.rjdb.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody UserPostDto userPostDto) throws ValidationException {
        userService.create(userPostDto);
    }
    @GetMapping("current")
    public UserDto getCurrent() throws ValidationException {
        return userService.getCurrent();
    }


}

