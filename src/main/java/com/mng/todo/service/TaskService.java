package com.mng.todo.service;

import com.mng.todo.model.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);
    List<Task> listTasks();
    Task getTaskById(Integer taskId);
    List<Task> UsersTasks(Integer userId);

    void deleteTask(Integer taskId);
}
