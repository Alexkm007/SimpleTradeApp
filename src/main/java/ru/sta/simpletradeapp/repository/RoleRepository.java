package ru.sta.simpletradeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sta.simpletradeapp.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String s);
}
