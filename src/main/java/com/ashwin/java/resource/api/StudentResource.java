package com.ashwin.java.resource.api;

import com.ashwin.java.domain.model.Student;
import com.ashwin.java.domain.service.StudentService;
import com.ashwin.java.resource.auth.JwtUtil;
import com.ashwin.java.resource.auth.UserPrincipal;
import com.ashwin.java.resource.dto.StudentMapper;
import com.ashwin.java.resource.dto.StudentReqDto;
import io.dropwizard.auth.Auth;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Path("/student")
public class StudentResource {
    private StudentMapper studentMapper;
    private StudentService studentService;

    @Inject
    public StudentResource(StudentMapper studentMapper, StudentService studentService) {
        this.studentMapper = studentMapper;
        this.studentService = studentService;
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public Response ping() {
        return Response.ok("pong").build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@NotNull @Valid Optional<StudentReqDto> studentRequestDto) {
        try {
            if (studentRequestDto.isPresent()) {
                Student student = studentMapper.toBo(studentRequestDto.get());
                if (student != null) {
                    String token = JwtUtil.generateToken(student);
                    Map<String, String> map = new HashMap<>();
                    map.put("token", token);
                    return Response.ok(map).build();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({ "admin" })
    public Response getAll(@Auth UserPrincipal user) {
        List<Student> students = studentService.getAll();
        if (students != null && !students.isEmpty()) {
            return Response.ok(studentMapper.toDto(students)).build();
        } else {
            return Response.noContent().build();
        }
    }
}
