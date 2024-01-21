package com.example.todo.controller;


import com.example.todo.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ToDoController {

    //private final List<Task> todoList = new ArrayList<>();
    private final DataService todoList;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todoList", todoList.getAllTasks());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String task, @RequestParam Boolean status, @RequestParam(required = false) String deadline){
//        Task newTask = new Task(task, status, deadline);
//        todoList.add(newTask);
        todoList.addTask(task, deadline, status);
        return "redirect:/";
    }

    @PostMapping ("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        todoList.deletedTask(id);
        return "redirect:/";
    }
}
