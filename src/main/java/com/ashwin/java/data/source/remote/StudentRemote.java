package com.ashwin.java.data.source.remote;

import com.ashwin.java.data.source.StudentDao;
import com.ashwin.java.domain.model.Student;

import javax.ws.rs.NotSupportedException;
import java.util.List;

public class StudentRemote implements StudentDao {
    @Override
    public void add(Student student) {
        throw new NotSupportedException();
    }

    @Override
    public List<Student> getAll() {
        throw new NotSupportedException();
    }

    @Override
    public Student getById(Long id) {
        throw new NotSupportedException();
    }

    @Override
    public Student getByEmail(String email) {
        throw new NotSupportedException();
    }

    @Override
    public void delete(Long id) {
        throw new NotSupportedException();
    }

    @Override
    public void deleteAll() {
        throw new NotSupportedException();
    }
}
