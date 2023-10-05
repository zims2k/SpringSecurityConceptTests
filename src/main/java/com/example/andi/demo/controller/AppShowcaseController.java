package com.example.andi.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/testit")
public class AppShowcaseController {

    @GetMapping
    public String doShowcase(){
        return "Showcasing app path...";
    }
}
