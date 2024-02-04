package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DataService {

    private final ToDoRepository toDoRepository;

    public void addTask (String description, String deadline, Boolean status){
        toDoRepository.save(new Task(description, status, deadline));
    }

    public List<Task> getAllTasks(){
        return toDoRepository.findAll();
    }

    public void deletedTask(Long id){
        toDoRepository.deleteById(id);
    }

    public void statusChange(Long id){
        Task todo = toDoRepository.findById(id).orElseThrow();
        todo.setStatus(!todo.getStatus());
        toDoRepository.save(todo);
    }
}
