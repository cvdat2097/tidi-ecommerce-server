package org.springlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Server is starting...");

        SpringApplication.run(App.class);

        System.out.println("Server started successfully!");
    }
}
