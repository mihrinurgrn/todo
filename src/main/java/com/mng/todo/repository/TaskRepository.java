package com.mng.todo.repository;

import com.mng.todo.model.Task;
import com.mng.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findAll();
    List<Task> findTasksByUser(User user);
    Task findTaskByTaskId(Integer taskId);

    @Override
    void delete(Task task);
}

