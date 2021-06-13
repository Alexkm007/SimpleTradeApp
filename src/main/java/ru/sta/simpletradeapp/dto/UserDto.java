package ru.sta.simpletradeapp.dto;

import lombok.Data;
import lombok.NonNull;
import ru.sta.simpletradeapp.model.Role;
import ru.sta.simpletradeapp.model.User;

import java.io.Serializable;
import java.util.List;

@Data
public class UserDto implements Serializable {
    private Long id;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String name;
    private String surname;
    @NonNull
    private String email;
    private String phoneNumber;
    private Boolean enabled;

    private List<Role> roles;

    public UserDto(User user) {

        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getLogin();
        this.phoneNumber = user.getPhoneNumber();
        this.enabled = user.getEnabled();
        this.roles = user.getRoles();

    }
}
