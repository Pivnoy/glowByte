package com.example.glow.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

}
