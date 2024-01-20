package com.example.todo.controller;


import com.example.todo.model.Task;
import com.example.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class ToDoController {

    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping
    public String index(Model model) {
        List<Task> todoList =  toDoRepository.findAll();
        model.addAttribute("todoList", todoList);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String task, @RequestParam String status, @RequestParam(required = false) String deadline){
        Task newTask = new Task(task, status, deadline);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        toDoRepository.deleteById(id);
        return "redirect:/";
    }
}
