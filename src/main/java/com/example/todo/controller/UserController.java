package com.example.todo.controller;

import com.example.todo.model.User;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return"login";
    }
//    @GetMapping("/login")
//    public String loginPageRedirect() {
//        return "register";
//    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        List<User> adminUsers = userRepository.findByIsAdmin(true);
        model.addAttribute("adminUsers", adminUsers);
        return "admin/dashboard";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return"register";
    }

    @PostMapping("/registration")
    public String registrationSubmit(@ModelAttribute("user") User user){
        userService.registerUser(user);
        user.setIsAdmin(user.getIsAdmin());
        return "redirect:/login"; // Presmeruje na login page po uspesne registraci
    }

}
