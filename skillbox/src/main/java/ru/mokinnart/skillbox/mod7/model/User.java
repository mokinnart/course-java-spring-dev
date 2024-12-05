package ru.mokinnart.skillbox.mod7.model;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;
@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String username;
    private String email;
}