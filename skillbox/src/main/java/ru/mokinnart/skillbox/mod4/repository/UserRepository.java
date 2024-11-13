package ru.mokinnart.skillbox.mod4.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ru.mokinnart.skillbox.mod4.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}