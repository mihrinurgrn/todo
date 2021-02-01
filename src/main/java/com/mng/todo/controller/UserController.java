package com.mng.todo.controller;

import com.mng.todo.model.User;
import com.mng.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/user"}, method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) {
        return userService.save(user);

    }

    @RequestMapping(value = {"/user/{id}"}, method = RequestMethod.GET)
    public User findUserById(@PathVariable(value = "id") Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = {"/user/{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
            userService.deleteUser(id);
            return ResponseEntity.status(204).build();
    }


    @RequestMapping(value = {"/user/{id}"}, method = RequestMethod.PUT)
    public User updateUser(@RequestBody User user, @PathVariable Integer id) {

        User userUpdated=userService.getUserById(id);
        return userUpdated;
    }




}