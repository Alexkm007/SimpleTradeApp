package ru.sta.simpletradeapp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sta.simpletradeapp.model.Role;
import ru.sta.simpletradeapp.model.User;
import ru.sta.simpletradeapp.repository.PermissionRepository;
import ru.sta.simpletradeapp.repository.RoleRepository;
import ru.sta.simpletradeapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService implements UserDetailsService {

    final UserRepository userRepository;
    final RoleRepository roleRepository;
    final PermissionRepository permissionRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
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

    public List<User>getAllUser(){
        List<User> users = userRepository.findAll();
        return  users;
    }

    private void initialization(){

        if(userRepository.findByName("admin")!=null) return;

        Role admin = new Role("Admin");
        roleRepository.save(admin);
        User userAdmin = new User();
        userAdmin.setEnabled(true);
        userAdmin.setName("admin");
        userAdmin.setPassword("$2y$12$j6rzwpKFqeDRXGJxMYcuzOQnIWbJAqZB5x.PX8iG/a.Hyn89Nini2");
        List<Role> roles= new ArrayList<>();
        roles.add(admin);
        userAdmin.setRoles(roles);
        userRepository.save(userAdmin);

    }

}
