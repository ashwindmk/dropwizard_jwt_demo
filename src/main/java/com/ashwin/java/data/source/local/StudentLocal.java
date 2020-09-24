package com.ashwin.java.data.source.local;

import com.ashwin.java.data.source.StudentDao;
import com.ashwin.java.domain.model.Student;

import javax.inject.Inject;
import java.util.*;

public class StudentLocal implements StudentDao {
    private Map<Long, Student> studentMap;

    @Inject
    public StudentLocal() {
        studentMap = new HashMap<>();
        studentMap.put(0L, new Student(0L, "Ashwin", "ashwin@gmail.com", "pass123", "root"));
        studentMap.put(1L, new Student(1L, "Alice", "alice@gmail.com", "pass123", "admin"));
        studentMap.put(2L, new Student(2L, "Bob", "bob@gmail.com", "pass123", "admin"));
        studentMap.put(3L, new Student(3L, "Clara", "clara@gmail.com", "pass123", "user"));
    }

    @Override
    public void add(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student getById(Long id) {
        return studentMap.get(id);
    }

    @Override
    public Student getByEmail(String email) {
        Optional<Map.Entry<Long, Student>> entry = studentMap.entrySet().stream()
                .filter(e -> e.getValue().getEmail().equals(email))
                .findFirst();
        if (entry.isPresent()) {
            return entry.get().getValue();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        studentMap.remove(id);
    }

    @Override
    public void deleteAll() {
        studentMap.clear();
    }
}
