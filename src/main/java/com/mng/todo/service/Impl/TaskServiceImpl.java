package com.mng.todo.service.Impl;

import com.mng.todo.model.Task;
import com.mng.todo.repository.TaskRepository;
import com.mng.todo.repository.UserRepository;
import com.mng.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Integer taskId) {
        return taskRepository.findTaskByTaskId(taskId);
    }

    @Override
    public List<Task> UsersTasks(Integer userId) {
        return taskRepository.findTasksByUser(userRepository.findUserByUserId(userId));
    }

    @Override
    public void deleteTask(Integer taskId) {
        taskRepository.delete(taskRepository.findTaskByTaskId(taskId));
    }
}
