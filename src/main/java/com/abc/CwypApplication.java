package com.abc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CwypApplication {

    public static void main(String[] args) {
        SpringApplication.run(CwypApplication.class, args);
    }
}