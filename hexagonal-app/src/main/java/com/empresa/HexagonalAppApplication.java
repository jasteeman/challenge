package com.empresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.empresa")
public class HexagonalAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(HexagonalAppApplication.class, args);
    }
}
