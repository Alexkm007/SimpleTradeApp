package ru.sta.simpletradeapp.controller;

import org.springframework.web.bind.annotation.*;
import ru.sta.simpletradeapp.dto.UserDto;
import ru.sta.simpletradeapp.model.User;
import ru.sta.simpletradeapp.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    final UserService  userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping()
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @RequestMapping("/edit/{id}")
    public UserDto getUser(@PathVariable("id") @NotNull Long id){
        UserDto userDto = userService.getUserById(id);
        return userDto;
    }

    @PostMapping("/add")
    public UserDto addUser(@Valid @RequestBody UserDto userDto){
        User userInBase = userService.findByLogin(userDto.getLogin());
        if (userInBase == null || userDto.getId() != null) return null;

        userDto = userService.addNewUser(userDto);
        return userDto;
    }

    @PutMapping("/update")
    public UserDto updateUser(@Valid @RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteUser(@PathVariable Long id){
       return userService.deleteUser(id);
    }



}
