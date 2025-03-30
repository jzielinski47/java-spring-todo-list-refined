package edu.todo.list.todoList.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class TaskPatchRequest {
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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
