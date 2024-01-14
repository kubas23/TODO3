package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {
    @GetMapping
    public String toDoMainPage (){
        return "index";
    }
}
