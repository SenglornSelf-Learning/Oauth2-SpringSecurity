package com.senglornOauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/welcome")
    public String home(){
        return("Hello, welcome to homepage!");
    }

    @GetMapping("/public")
    Map<String, String> getPublic(){
        return Map.of("public", "API data public");
    }

    @GetMapping("/private")
    Map<String, String> getPrivate(){
        return Map.of("private", "API data private");
    }
}
