package edu.todo.list.todoList.repositories;

import edu.todo.list.todoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public Task findByName(String name);
    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
    public List<Task> findByPriority(int priority);
    public List<Task> findAll();
    public Task getById(Long id);
}
