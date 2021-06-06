package ru.sta.simpletradeapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Permission implements Serializable {

    @Id
    @SequenceGenerator(name = "permission_seq", sequenceName = "permission_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "permission_seq")
    private Long id;
    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
