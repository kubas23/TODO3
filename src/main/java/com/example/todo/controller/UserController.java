package com.example.todo.controller;

import com.example.todo.exceptions.UserAlreadyExistsException;
import com.example.todo.model.User;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return"login";
    }

//    @GetMapping("/login")
//    public String loginPageRedirect() {
//        return "register";
//    }

    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return"register";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute("user") User user, Model model){
        try{
            userService.registerUser(user);
            return "redirect:/login"; // Presmeruje na login page po uspesne registraci
        }catch (UserAlreadyExistsException ex){
            model.addAttribute("errorMessage", ex.getMessage());
            return "register";
        }

    }

}
