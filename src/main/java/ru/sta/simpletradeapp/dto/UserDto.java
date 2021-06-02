package ru.sta.simpletradeapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private UUID id;
    private String name;
    private String surname;
    private String patronymic;
    private String login;
    private String email;
    private String phoneNumber;
}
