package com.example.bot.controller;

import com.example.bot.model.User;
import com.example.bot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public User findById(int id) {
        return userService.findById(id);
    }
}
