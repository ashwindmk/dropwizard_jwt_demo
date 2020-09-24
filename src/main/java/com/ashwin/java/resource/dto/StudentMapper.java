package com.ashwin.java.resource.dto;

import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.service.StudentService;

import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudentMapper {
    private StudentService studentService;

    private Function<Student, StudentResDto> toDtoFun = (Student s) -> new StudentResDto(s.getName(), s.getEmail());

    private Function<StudentReqDto, Student> toBoFun = (StudentReqDto r) -> studentService.authenticate(r.getEmail(), r.getPassword());

    @Inject
    public StudentMapper(StudentService studentService) {
        this.studentService = studentService;
    }

    public Student toBo(StudentReqDto studentReqDto) {
        return toBoFun.apply(studentReqDto);
    }

    public List<StudentResDto> toDto(List<Student> students) {
        return students.stream()
                .map(toDtoFun)
                .collect(Collectors.toList());
    }
}
