package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.model.User;
import com.example.todo.repository.ToDoRepository;
import com.example.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class DataService {

    private final ToDoRepository toDoRepository;
    private final UserRepository userRepository;


    public void deletedTask(Long id){
        toDoRepository.deleteById(id);
    }

    public void statusChange(Long id){
        Task todo = toDoRepository.findById(id).orElseThrow();
        todo.setStatus(!todo.getStatus());
        toDoRepository.save(todo);
    }

    public void addTask(String description, String deadline, Boolean status) {
        // Get the username of the currently logged-in user
        String username = getUsernameOfLoggedInUser();

        // Find the user by username
        Optional<User> userOptional = userRepository.findByUsername(username);

        // Check if the user exists
        if (userOptional.isPresent()) {
            // User exists, create and save the task associated with the user
            User user = userOptional.get();
            Task task = new Task(description, status, deadline);
            task.setUser(user);
            toDoRepository.save(task);
        } else {
            // Handle the case where the user doesn't exist
            throw new RuntimeException("Logged-in user not found in the database");
        }
    }

    public List<Task> getAllTasks(){
        String username = getUsernameOfLoggedInUser();

        // Find the user by username
        Optional<User> userOptional = userRepository.findByUsername(username);

        // Check if the user exists
        if (userOptional.isPresent()) {
            // User exists, fetch tasks associated with the user
            User user = userOptional.get();
            return toDoRepository.findByUser(user);
        } else {
            // Handle the case where the user doesn't exist
            throw new RuntimeException("Logged-in user not found in the database");
        }
    }

    public String getUsernameOfLoggedInUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
}
