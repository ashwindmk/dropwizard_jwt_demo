package com.ashwin.java.domain.service;

import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.repository.StudentRepository;

import javax.inject.Inject;
import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;

    @Inject
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getOne() {
        return studentRepository.getOne();
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public Student authenticate(String email, String password) {
        Student student = studentRepository.getByEmail(email);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }
}
