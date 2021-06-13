package ru.sta.simpletradeapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import ru.sta.simpletradeapp.dto.UserDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "usr")
public class User implements UserDetails, Serializable {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private Boolean enabled;

    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.login = userDto.getLogin();
        this.password = userDto.getPassword();
        this.name = userDto.getName();
        this.surname = userDto.getSurname();
        this.email = userDto.getLogin();
        this.phoneNumber = userDto.getPhoneNumber();
        this.enabled = userDto.getEnabled();
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void updateFields(UserDto userDto){
        this.login = userDto.getLogin();
        this.name = userDto.getName();
        this.surname = userDto.getSurname();
        this.email = userDto.getLogin();
        this.phoneNumber = userDto.getPhoneNumber();
        this.enabled = userDto.getEnabled();
    }

}
