package com.sales.initializer;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;

public class Postgres {

    public static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:14");

    public static class Initilizer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(@NotNull ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.driver-class-name=" + container.getDriverClassName(),
                    "spring.datasource.url=" + container.getJdbcUrl() + "?currentSchema=sales",
                    "spring.datasource.username=" + container.getUsername(),
                    "spring.datasource.password=" + container.getPassword(),
                    "spring.flyway.url=" + container.getJdbcUrl(),
                    "spring.flyway.user=" + container.getUsername(),
                    "spring.flyway.password=" + container.getPassword()
            ).applyTo(applicationContext);
        }
    }


}
