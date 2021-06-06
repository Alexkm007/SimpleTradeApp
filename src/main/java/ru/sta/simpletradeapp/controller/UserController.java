package ru.sta.simpletradeapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sta.simpletradeapp.model.User;
import ru.sta.simpletradeapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    final UserService  userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping()
    List<User> getAllUsers(){
        return userService.getAllUser();
    }

}
