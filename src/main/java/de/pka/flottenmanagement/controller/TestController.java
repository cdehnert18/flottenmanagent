package de.pka.flottenmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    int a = 0;

    @GetMapping
    public int get42(){
        return a++;
    }
}
