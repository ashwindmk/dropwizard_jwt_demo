package com.ashwin.java;

import com.ashwin.java.resource.api.StudentHealthCheck;
import com.ashwin.java.resource.api.StudentResource;
import com.ashwin.java.resource.auth.JwtAuthenticator;
import com.ashwin.java.resource.auth.JwtAuthorizer;
import com.ashwin.java.resource.auth.UserPrincipal;
import com.ashwin.java.resource.di.JwtDemoModules;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class JwtDemoApplication extends Application<JwtDemoConfiguration> {
    public static void main(String[] args) throws Exception {
        new JwtDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard-jwt-demo";
    }

    @Override
    public void run(JwtDemoConfiguration config, Environment env) throws Exception {
        env.jersey().getResourceConfig().register(new JwtDemoModules());

        // Auth filter
        env.jersey().register(new AuthDynamicFeature(new OAuthCredentialAuthFilter.Builder<UserPrincipal>()
                .setAuthenticator(new JwtAuthenticator())
                .setAuthorizer(new JwtAuthorizer())
                .setPrefix("Bearer")
                .buildAuthFilter()
        ));
        env.jersey().register(RolesAllowedDynamicFeature.class);
        env.jersey().register(new AuthValueFactoryProvider.Binder<>(UserPrincipal.class));

        // Resources
        env.jersey().register(StudentResource.class);

        // Health
        env.healthChecks().register("student", new StudentHealthCheck());
    }
}
