package com.mng.todo.controller;

import com.mng.todo.model.User;
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
public class UserControllerTest extends AbstractTest {


    @MockBean
    UserService userServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Override
    public void setUp() {
        super.setUp();
    }
    @Test
    public void saveUser() throws Exception {
        String uri = "/user";
        User user = new User();
        user.setUserName("mihrinurgrn");
        user.setPassword("mihri123");
        user.setEmail("mihrinurgrn@gmail.com");
        user.setRole(1);
        Mockito.when(userServiceMock.save(Mockito.any(User.class))).thenReturn(user);


        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, inputJson);
    }


    @Test
    public void updateUser() throws Exception {
        String uri = "/user/6";
        User user = new User();
        user.setUserName("mihrinurgrn");
        user.setPassword("mmmmmmm");
        user.setEmail("mihrinurgrn@gmail.com");
        user.setRole(1);

        Mockito.when(userServiceMock.getUserById(6)).thenReturn(user);

        String inputJson = super.mapToJson(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, inputJson);
    }
    @Test
    public void deleteUser() throws Exception {
        String uri = "/user/6";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(204, status);
        int content = mvcResult.getResponse().getStatus();
        assertEquals(content, status);
    }
}
