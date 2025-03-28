package edu.todo.list.todoList.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Min(value = 0, message = "Minimum priority is 0")
    @Max(value = 5, message = "Maximum priority is 5")
    private int priority;
    private boolean completed;

    public Task(String name, int priority, boolean completed) {
        this.name = name;
        this.priority = priority;
        this.completed = completed;
    }

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public Task(String name) {
        this.name = name;
        this.priority = 0;
        this.completed = false;
    }

    public Task() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
