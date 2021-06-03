package ru.sta.simpletradeapp.model;

import lombok.*;

import javax.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Table(name = "usr")
public class User {

    @Id
    private UUID id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Role> roles;

}
