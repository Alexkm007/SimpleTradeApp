package ru.sta.simpletradeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sta.simpletradeapp.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String Name);
}
