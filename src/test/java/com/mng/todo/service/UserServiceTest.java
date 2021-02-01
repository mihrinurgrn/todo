package com.mng.todo.service;


import com.mng.todo.controller.AbstractTest;
import com.mng.todo.model.User;
import com.mng.todo.repository.UserRepository;
import com.mng.todo.service.Impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;


public class UserServiceTest extends AbstractTest {


    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;


    @Test
    public void findById() {
        User user = new User();
        user.setUserId(2);
        Mockito.when(userRepository.findUserByUserId(2)).thenReturn(user);
        Assert.assertEquals(user,userService.getUserById(2));


    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setEmail("asdf@gmail.com");
        user.setUserName("qwert");
        user.setPassword("asdfgh");
        user.setRole(1);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assert.assertEquals(user,userService.save(user));


    }

    @Test
    public void deleteUser() {
        User user = new User();
        user.setUserId(2);
        user.setEmail("asdf@gmail.com");
        user.setUserName("qwert");
        user.setPassword("asdfgh");
        user.setRole(1);

        Mockito.when(userRepository.findUserByUserId(2)).thenReturn(user);
        doNothing().when(userRepository).delete(user);

        userService.deleteUser(user.getUserId());
        Mockito.verify(userRepository, times(1)).delete(user);

    }

    @Test
    public void getUserByUserName() {
        User user = new User();
        user.setEmail("asdf@gmail.com");
        user.setUserName("qwert");
        user.setPassword("asdfgh");
        user.setRole(1);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assert.assertEquals(user,userService.save(user));


    }



}
