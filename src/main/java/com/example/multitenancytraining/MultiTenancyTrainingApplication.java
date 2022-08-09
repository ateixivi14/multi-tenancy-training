package com.example.multitenancytraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MultiTenancyTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiTenancyTrainingApplication.class, args);
    }

}
