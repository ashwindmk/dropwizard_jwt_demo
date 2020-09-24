package com.ashwin.java.domain.repository;

import com.ashwin.java.domain.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getAll();

    Student getOne();

    Student getById(Long id);

    Student getByEmail(String email);
}
