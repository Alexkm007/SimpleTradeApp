package ru.sta.simpletradeapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "usr")
public class User {

    @Id
    private UUID id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Role> roles;

}
