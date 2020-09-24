package com.ashwin.java.resource.auth;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;

import java.util.Optional;

public class JwtAuthenticator implements Authenticator<String, UserPrincipal> {
    @Override
    public Optional<UserPrincipal> authenticate(String token) throws AuthenticationException {
        System.out.println("Authneticate ...");
        UserPrincipal userPrincipal = JwtUtil.decodeToken(token);
        if (userPrincipal != null) {
            return Optional.of(userPrincipal);
        }
        return Optional.empty();
    }
}
