package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DataService {

    private final ToDoRepository toDoRepository;

    public void addTask (String description, String deadline, boolean status){
        toDoRepository.save(new Task(description, status, deadline));
    }
}
