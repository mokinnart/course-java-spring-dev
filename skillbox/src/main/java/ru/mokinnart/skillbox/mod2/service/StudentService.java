package ru.mokinnart.skillbox.mod2.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ru.mokinnart.skillbox.mod2.model.Student;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private long currentId = 1;
    public Student addStudent(String firstName, String lastName, int age) {
        var student = new Student(currentId++, firstName, lastName, age);
        students.put(student.getId(), student);
        return student;
    }
    public Student removeStudent(Long id) {
        if (!students.containsKey(id))
            throw new IllegalArgumentException("Студента с id=%d не существует!".formatted(id));
        return students.remove(id);
    }
    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
    public void clearStudents() {
        students.clear();
    }
}