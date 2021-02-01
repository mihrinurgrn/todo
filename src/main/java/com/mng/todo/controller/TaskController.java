package com.mng.todo.controller;

import com.mng.todo.model.Task;
import com.mng.todo.service.TaskService;
import com.mng.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/task"}, method = RequestMethod.POST)
    public Task saveTask(@RequestBody Task task) {
        taskService.save(task);
        return task;
    }

    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public List<Task> listTask() {
        return taskService.listTasks();
    }


    @RequestMapping(value = {"/task/{id}"}, method = RequestMethod.GET)
    public Task findTaskById(@PathVariable(value = "id") Integer id) {
        return taskService.getTaskById(id);
    }

    @RequestMapping(value = {"/tasks/{id}"}, method = RequestMethod.GET)
    public List<Task> findTaskByUserId(@PathVariable(value = "id") Integer id) {
        return taskService.UsersTasks(id);
    }

    @RequestMapping(value = {"/task/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.status(204).build();
    }

    @RequestMapping(value = {"/task/{id}"}, method = RequestMethod.PUT)
    public Task updateTask(@RequestBody Task task, @PathVariable Integer id) {

        Task taskUpdated=taskService.getTaskById(id);
        if(task!=taskUpdated)
        {
            taskUpdated.setTaskName(task.getTaskName());
            taskUpdated.setTaskBody(task.getTaskBody());
            taskService.save(taskUpdated);
        }
        return taskUpdated;
    }

}