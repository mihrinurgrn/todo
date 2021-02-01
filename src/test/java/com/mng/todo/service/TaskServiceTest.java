package com.mng.todo.service;

import com.mng.todo.controller.AbstractTest;
import com.mng.todo.model.Task;
import com.mng.todo.model.User;
import com.mng.todo.repository.TaskRepository;
import com.mng.todo.repository.UserRepository;
import com.mng.todo.service.Impl.TaskServiceImpl;
import com.mng.todo.service.Impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;

public class TaskServiceTest extends AbstractTest {
    @MockBean
    private TaskRepository taskRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void findById() {
        Task task = new Task();
        task.setTaskId(2);
        Mockito.when(taskRepository.findTaskByTaskId(2)).thenReturn(task);
        Assert.assertEquals(task,taskService.getTaskById(2));


    }

    @Test
    public void saveTask() {
        User user=new User();
        user.setUserId(2);
        user.setPassword("123");
        user.setEmail("nmg@gmail.com");
        user.setUserName("mng");
        user.setRole(1);

        Task task = new Task();
        task.setTaskName("mihrinurgrn");
        task.setTaskId(6);
        task.setTaskBody("mmmmmmm");
        task.setUser(user);


        Mockito.when(taskRepository.save(task)).thenReturn(task);
        Assert.assertEquals(task,taskService.save(task));


    }

    @Test
    public void deleteTask() {
        Task task = new Task();
        task.setTaskId(2);
        task.setTaskName("mihrinurgrn");
        task.setTaskBody("mmmmmmm");


        Mockito.when(taskRepository.findTaskByTaskId(2)).thenReturn(task);
        doNothing().when(taskRepository).delete(task);

        taskService.deleteTask(task.getTaskId());
        Mockito.verify(taskRepository, times(1)).delete(task);

    }
    //return taskRepository.findTasksByUser(userRepository.findUserByUserId(userId));
    @Test
    public void getTasksForSpecificUser()
    {
        User user=new User();
        user.setUserId(3);

        Task task = new Task();
        task.setTaskName("mihrinurgrn");
        task.setTaskBody("mmmmmmm");
        task.setUser(user);


        List<Task> tasks=new ArrayList<>();

        tasks.add(task);

        Mockito.when(userRepository.findUserByUserId(3)).thenReturn(user);
        Mockito.when(taskRepository.findTasksByUser(user)).thenReturn(tasks);
        Assert.assertEquals(tasks,taskService.UsersTasks(3));
    }


}
