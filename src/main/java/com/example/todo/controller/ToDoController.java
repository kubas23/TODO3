package com.example.todo.controller;


import com.example.todo.model.Task;
import com.example.todo.repository.ToDoRepository;
import com.example.todo.service.DataService;
import com.example.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ToDoController {
    private final DataService todoList;
    private final UserService userService;


    @GetMapping
    public String index(Model model) {
        model.addAttribute("todoList", todoList.getAllTasks());
        model.addAttribute("userRole", userService.getLoggedInUserRole());
        log.info(userService.getLoggedInUserRole());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String task, @RequestParam Boolean status, @RequestParam(required = false) String deadline){
        todoList.addTask(task, deadline, status);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        todoList.deletedTask(id);
        return "redirect:/";
    }

    @PostMapping("/statusChange")
    public String statusChange (@RequestParam Long id){
        todoList.statusChange(id);
        return "redirect:/";
    }
}
