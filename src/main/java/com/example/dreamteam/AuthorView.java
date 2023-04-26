package com.example.dreamteam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorView {
    @GetMapping("/")
    public String home() {
        return "Welcome to the Author API!";
    }
}
