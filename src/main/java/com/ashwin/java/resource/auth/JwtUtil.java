package com.ashwin.java.resource.auth;

import com.ashwin.java.domain.model.Student;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.*;

public class JwtUtil {
    private static final String ISSUER = "auth0";
    private static final long ONE_HOUR = 60 * 60 * 1000L;
    private static final long EXPIRATION = 24 * ONE_HOUR;
    private static final String SECRET_KEY = "secr123";

    public static String generateToken(Student student) {
        Set<String> roles = Role.valueOf(student.getRole().toUpperCase()).getRoles();
        UserPrincipal userPrincipal = new UserPrincipal(student.getEmail(), roles);
        return generateToken(userPrincipal);
    }

    private static String generateToken(UserPrincipal user) {
        String token = null;
        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
            token = JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.getName())
                    .withClaim("name", user.getName())
                    .withArrayClaim("roles", user.getRoles().toArray(new String[0]))
                    .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION))
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }
        return token;
    }

    public static UserPrincipal decodeToken(String token) {
        UserPrincipal principal = null;
        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            DecodedJWT jwt = verifier.verify(token);

            String name = jwt.getSubject();

            Claim rolesClaim = jwt.getClaim("roles");
            String[] roles = rolesClaim.asArray(String.class);
            Set<String> roleSet =  new HashSet<>(Arrays.asList(roles));

            principal = new UserPrincipal(name, roleSet);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return principal;
    }
}
