package ru.sta.simpletradeapp.dto;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

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
}
