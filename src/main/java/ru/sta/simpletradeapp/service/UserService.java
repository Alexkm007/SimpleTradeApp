package ru.sta.simpletradeapp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sta.simpletradeapp.dto.UserDto;
import ru.sta.simpletradeapp.model.Role;
import ru.sta.simpletradeapp.model.User;
import ru.sta.simpletradeapp.repository.PermissionRepository;
import ru.sta.simpletradeapp.repository.RoleRepository;
import ru.sta.simpletradeapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        initialization();
        User user = userRepository.findByName(s);
        if(user != null){
            return user;
        }
        throw new UsernameNotFoundException("User " + s + " not found");
    }

    public User findByUsername(String s){
        return userRepository.findByName(s);
    }

    public User finndByLogin(String s){
        return userRepository.findByLogin(s);
    }

    public List<User>getAllUser(){
        List<User> users = userRepository.findAll();
        return  users;
    }

    public UserDto registration(UserDto userDto){

        User user = userRepository.findByName(userDto.getName());
        if (user != null) {
            return null;
        }

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userDto.setEnabled(true);
        user = new User(userDto);
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("Admin"));
        user.setRoles(roles);
        userRepository.saveAndFlush(user);
        userDto.setId(user.getId());
        return userDto;

    }

    public UserDto getUserById(Long id){

        User user = userRepository.findById(id).get();
        if(user == null) return null;
        return new UserDto(user);

    }

    private void initialization(){

        if(userRepository.findByName("admin")!=null) return;

        Role admin = new Role("Admin");
        roleRepository.save(admin);
        User userAdmin = new User();
        userAdmin.setEnabled(true);
        userAdmin.setName("admin");
        userAdmin.setLogin("admin");
        userAdmin.setPassword("$2y$12$j6rzwpKFqeDRXGJxMYcuzOQnIWbJAqZB5x.PX8iG/a.Hyn89Nini2");
        List<Role> roles= new ArrayList<>();
        roles.add(admin);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);

    }


}
