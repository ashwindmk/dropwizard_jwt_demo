package com.ashwin.java.data.source;

import com.ashwin.java.domain.model.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);

    List<Student> getAll();

    Student getById(Long id);

    Student getByEmail(String email);

    void delete(Long id);

    void deleteAll();
}
