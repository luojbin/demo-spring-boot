package com.luojbin.demo.spring.boot.dependencies;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return Health.down().withDetail("reason", "自定义的health指示器").build();
    }
}
