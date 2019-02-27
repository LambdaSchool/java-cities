package com.pabloogata.javacities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaCitiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaCitiesApplication.class, args);

    }

}
