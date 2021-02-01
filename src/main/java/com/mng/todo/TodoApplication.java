package com.mng.todo;

import com.mng.todo.model.User;
import com.mng.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

    public static void main(String[] args) throws Throwable {
            SpringApplication.run(TodoApplication.class, args);
        }
    }


