package ru.mokinnart.skillbox.mod2.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.mokinnart.skillbox.mod2.model.Student;

@AllArgsConstructor
@Getter
public class StudentCreatedEvent {
    private final Student student;
}