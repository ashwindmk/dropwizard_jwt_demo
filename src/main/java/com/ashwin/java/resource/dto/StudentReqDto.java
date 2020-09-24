package com.ashwin.java.resource.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Student Request DTO
 */
public class StudentReqDto implements Serializable {
    @NotNull
    private String email;

    @NotNull
    private String password;

    public StudentReqDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "StudentReqDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
