package edu.todo.list.todoList.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TaskRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Min(value = 0, message = "Minimum priority is 0")
    @Max(value = 5, message = "Maximum priority is 5")
    private int priority = 0;
    private boolean completed = false;

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

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
