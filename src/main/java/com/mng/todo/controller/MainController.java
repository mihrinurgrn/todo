package com.mng.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/user")
    public String loginUser(){
        return "User kullanıcı girişi başarılı";
    }

    @RequestMapping("/admin")
    public String loginAdmin(){
        return "Admin kullanıcı girişi başarılı";
    }
}
