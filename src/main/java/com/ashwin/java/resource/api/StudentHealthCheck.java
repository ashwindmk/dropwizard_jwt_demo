package com.ashwin.java.resource.api;

import com.codahale.metrics.health.HealthCheck;

public class StudentHealthCheck extends HealthCheck {
    @Override
    protected Result check() throws Exception {
        try {
            return Result.healthy();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.unhealthy(e);
        }
    }
}
