package com.ashwin.java.resource.auth;

import com.google.common.collect.ImmutableSet;

public enum Role {
    GUEST("guest", ImmutableSet.of()),
    USER("user", ImmutableSet.of("user")),
    ADMIN("admin", ImmutableSet.of("admin", "user")),
    ROOT("root", ImmutableSet.of("root", "admin", "user"));

    private final String user;
    private final ImmutableSet<String> roles;

    Role(String user, ImmutableSet<String> roles) {
        this.user = user;
        this.roles = roles;
    }

    public String getUser() {
        return this.user;
    }

    public ImmutableSet<String> getRoles() {
        return this.roles;
    }

    public Role getValue(String role) {
        try {
            return valueOf(role.toUpperCase());
        } catch (Exception e) {
            return GUEST;
        }
    }
}
