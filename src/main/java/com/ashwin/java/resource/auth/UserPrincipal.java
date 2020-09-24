package com.ashwin.java.resource.auth;

import java.security.Principal;
import java.util.Set;

public class UserPrincipal implements Principal {
    private final String email;
    private final Set<String> roles;

    public UserPrincipal() {
        this.email = null;
        this.roles = null;
    }

    public UserPrincipal(String email) {
        this.email = email;
        this.roles = null;
    }

    public UserPrincipal(String email, Set<String> roles) {
        this.email = email;
        this.roles = roles;
    }

    @Override
    public String getName() {
        return email;
    }

    public int getId() {
        return (int) (Math.random() * 100);
    }

    public Set<String> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "UserPrincipal{" +
                "email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}

