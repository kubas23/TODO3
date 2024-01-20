package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DataService {

    private final ToDoRepository toDoRepository;
    private final List<Task> todoList = new ArrayList<>();

    public void addTask (String description, String deadline, boolean status){
        toDoRepository.save(new Task(description, status, deadline));
    }
}
