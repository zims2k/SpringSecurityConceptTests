package com.example.andi.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Showcases a "/hugo/**" endpoint with a single @{@link GetMapping}.
 */
@RestController
@RequestMapping("/hugo/testit")
public class HugoShowcaseController {

    @GetMapping
    public String doShowcase(){
        return "Showcasing hugo path...";
    }
}
