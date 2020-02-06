package edu.miu.cs.cs544.a202001.wind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class HomeController {
    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }
    @GetMapping(value = "/**/{path:[^.]*}")
    public String any() {
        return "forward:/";
    }
}
