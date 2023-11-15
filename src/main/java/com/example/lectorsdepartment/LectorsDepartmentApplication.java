package com.example.lectorsdepartment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LectorsDepartmentApplication {
    private static final String GREETING_MESSAGE = "Hello! Please, write your request.";

    public static void main(String[] args) {
        SpringApplication.run(LectorsDepartmentApplication.class, args);
        System.out.println(GREETING_MESSAGE);
    }
}
