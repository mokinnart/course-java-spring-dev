package ru.mokinnart.skillbox.mod4.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.mokinnart.skillbox.mod4.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}