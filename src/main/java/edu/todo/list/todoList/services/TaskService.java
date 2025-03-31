package edu.todo.list.todoList.services;

import edu.todo.list.todoList.models.Task;
import edu.todo.list.todoList.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getById(Long taskId) {
        return taskRepository.getById(taskId);
    }

    public List<Task> getAllCompletedTasks() {
        return taskRepository.findByCompletedTrue();
    }

    public List<Task> getAllIncompleteTasks() {
        return taskRepository.findByCompletedFalse();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getPriorityTasks(int priority) {
        return taskRepository.findByPriority(priority);
    }

    public List<Task> getPriorityTasksRange(int min, int max) {
        return taskRepository.findByPriorityRange(min, max);
    }
}
