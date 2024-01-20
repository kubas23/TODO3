package com.example.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private String status;
    private String deadline;

    public Task(String description, String status, String deadline){
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }

    public Task() {

    }
}
