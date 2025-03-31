package edu.todo.list.todoList.controllers;

import edu.todo.list.todoList.models.Task;
import edu.todo.list.todoList.models.TaskPatchRequest;
import edu.todo.list.todoList.models.TaskRequest;
import edu.todo.list.todoList.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.getAllCompletedTasks());
    }

    @GetMapping("/incompleted")
    public ResponseEntity<List<Task>> getAllIncompleteTasks() {
        return ResponseEntity.ok(taskService.getAllIncompleteTasks());
    }

    @GetMapping("/{priority}")
    public ResponseEntity<List<Task>> getPriorityTasks(@Valid @PathVariable int priority) {
        return ResponseEntity.ok(taskService.getPriorityTasks(priority));
    }

    @GetMapping("/priority")
    public ResponseEntity<List<Task>> getPriorityTasks(@Valid @RequestParam(defaultValue = "0") int min, @Valid @RequestParam(defaultValue = "0") int max) {

        if(min != 0 && max != 0 && min > max)
            throw new IllegalArgumentException("min > max");
        if(min != 0 && max != 0)
            return ResponseEntity.ok(taskService.getPriorityTasksRange(min, max));
        if(min != 0)
            return ResponseEntity.ok(taskService.getPriorityTasksRange(min, 5));
        if(max != 0)
            return ResponseEntity.ok(taskService.getPriorityTasksRange(0, max));

        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequest req) {
        Task task = new Task(req.getName(), req.getPriority(), req.isCompleted());
        return ResponseEntity.ok(taskService.createNewTask(task));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> patchTask(@PathVariable Long id, @RequestBody TaskPatchRequest req) {
        Task task = taskService.getById(id);

        if(req.getName() != null)
            task.setName(req.getName());
        if(req.getPriority() != null)
            task.setPriority(req.getPriority());
        if(req.getCompleted() != null)
            task.setCompleted(req.getCompleted());

        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskRequest req) {
        Task task = new Task(req.getName(), req.getPriority(), req.isCompleted());
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }

}
