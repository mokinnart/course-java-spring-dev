package ru.mokinnart.skillbox.mod2.util;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.mokinnart.skillbox.mod2.service.StudentService;

// @Component
@RequiredArgsConstructor
// @ConfigurationProperties(prefix = "student.initializer")
public class StartupStudentInitializer {
    @Setter
    private boolean enabled;
    private final StudentService studentService;
    @PostConstruct
    public void init() {
        if (enabled) {
            studentService.addStudent("John", "Doe", 22);
            studentService.addStudent("Jane", "Smith", 23);
        }
    }
}
