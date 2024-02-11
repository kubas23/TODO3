package com.example.todo.model;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Getter
    private String role;

    public void setRole(String role) {
        this.role = role;
    }
}
