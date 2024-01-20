package com.example.todo.controller;


import com.example.todo.model.Task;
import com.example.todo.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {

   private final List<Task> todoList = new ArrayList<>();
//    @Autowired
//    DataService todoList;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todoList", todoList);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String task, @RequestParam Boolean status, @RequestParam(required = false) String deadline){
        Task newTask = new Task(task, status, deadline);
        todoList.add(newTask);
        return "redirect:/";
    }

    @PutMapping ("/delete/{id}")
    public String deleteTask(@RequestParam Long id) {
        //todoList.
        return "redirect:/";
    }
}
