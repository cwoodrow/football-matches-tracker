package fr.maif.football.matches.tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/hello")
    public String home(){
        System.out.println("home");
        return "Hello World";
    }
}
