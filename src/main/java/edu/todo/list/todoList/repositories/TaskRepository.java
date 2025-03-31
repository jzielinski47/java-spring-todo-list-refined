package edu.todo.list.todoList.repositories;

import edu.todo.list.todoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public Task findByName(String name);
    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
    public List<Task> findByPriority(int priority);
    @Query("SELECT t FROM Task t WHERE t.priority BETWEEN :min AND :max")
    public List<Task> findByPriorityRange(int min, int max);
    public List<Task> findAll();
    public Task getById(Long id);
}
