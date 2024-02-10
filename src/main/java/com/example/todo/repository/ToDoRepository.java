package com.example.todo.repository;

import com.example.todo.model.Task;
import com.example.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(boolean status);
    List<Task> findAllByUserId(Long userId);
    List<Task> findByUser(User user);


}
