package com.example.todo.model;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Boolean status;
    private String deadline;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task(String description, Boolean status, String deadline){
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }


}
