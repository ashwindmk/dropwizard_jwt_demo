package com.ashwin.java.resource.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Student Response DTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentResDto implements Serializable {
    private String name;

    @NotNull
    private String email;

    public StudentResDto() {
    }

    public StudentResDto(String name, @NotNull String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentResDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
