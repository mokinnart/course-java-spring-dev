package ru.mokinnart.skillbox.mod7.repository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import ru.mokinnart.skillbox.mod7.model.User;
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {
}