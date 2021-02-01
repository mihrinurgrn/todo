package com.mng.todo.controller;

import com.mng.todo.model.Task;
import com.mng.todo.model.User;
import com.mng.todo.service.TaskService;
import com.mng.todo.service.UserService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

public class TaskControllerTest extends AbstractTest {
    @MockBean
    TaskService taskServiceMock;

    @MockBean
    UserService userServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Override
    public void setUp() {
        super.setUp();
    }
    @Test
    public void saveTask() throws Exception {
        String uri = "/task";
        Task task = new Task();
        task.setTaskBody("mihrinurgrn");
        task.setTaskName("mihri123");
        task.setUser(userServiceMock.getUserById(2));

        Mockito.when(taskServiceMock.save(Mockito.any(Task.class))).thenReturn(task);


        String inputJson = super.mapToJson(task);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, inputJson);
    }


    @Test
    public void updateTask() throws Exception {
        String uri = "/task/6";

        User user=new User();
        user.setUserId(2);
        user.setPassword("123");
        user.setEmail("nmg@gmail.com");
        user.setUserName("mng");
        user.setRole(1);

        Task task = new Task();
        task.setTaskName("mihrinurgrn");
        task.setTaskBody("mmmmmmm");
        task.setUser(user);

        Mockito.when(userServiceMock.getUserById(2)).thenReturn(user);
        Mockito.when(taskServiceMock.getTaskById(6)).thenReturn(task);

        String inputJson = super.mapToJson(task);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, inputJson);
    }
    @Test
    public void deleteTask() throws Exception {
        String uri = "/task/6";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
        int content = mvcResult.getResponse().getStatus();
        assertEquals(content, status);
    }
}
