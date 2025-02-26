package com.example.practice.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;

@RestController
public class MainController {
    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        return "home";
    }
}
