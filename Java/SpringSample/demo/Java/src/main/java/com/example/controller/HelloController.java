
package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot!";
    }
    
    @GetMapping("/greet")
    public Message greet() {
        return new Message("Welcome to Spring Boot REST API!");
    }
}
