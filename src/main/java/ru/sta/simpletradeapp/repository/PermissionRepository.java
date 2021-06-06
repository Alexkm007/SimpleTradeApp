package ru.sta.simpletradeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sta.simpletradeapp.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByPermission(String s);
}
