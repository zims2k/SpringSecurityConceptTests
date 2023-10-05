package com.example.andi.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Showcases an "/other/**" endpoint with a single @{@link GetMapping}.
 */
@RestController
@RequestMapping("/other/testit")
public class OtherShowcaseController {

    @GetMapping
    public String doShowcase(){
        return "Showcasing other path...";
    }
}
