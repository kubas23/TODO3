package com.example.todo.controller;

public class Task {

    private static Long idCounter = 1L;

    private Long id;
    private String description;
    private String status;
    private String deadline;

    public Task(String description, String status, String deadline){
        this.id = idCounter++;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }
}
