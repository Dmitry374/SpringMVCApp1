package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/first")
public class FirsController {

    @GetMapping("/hello")
    public String helloPage() {
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}