package com.ashwin.java.data.repositoryimpl;

import com.ashwin.java.data.source.StudentDao;
import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.repository.StudentRepository;

import javax.inject.Inject;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private StudentDao studentDao;

    @Inject
    public StudentRepositoryImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public Student getOne() {
        return getById(0L);
    }

    @Override
    public Student getById(Long id) {
        return studentDao.getById(id);
    }

    @Override
    public Student getByEmail(String email) {
        return studentDao.getByEmail(email);
    }
}
