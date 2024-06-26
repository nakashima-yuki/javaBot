package com.example.bot.controller;

import com.example.bot.model.Result;
import com.example.bot.model.User;
import com.example.bot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public User findById(int id) {
        return userService.findById(id);
    }

    @PostMapping("/register")
    public Result register(String email , String password) {
        User user = userService.findByEmail(email);

        if(user == null) {
            return Result.error("该邮箱已注册!");
        }

        userService.regiser(email,password);

        return Result.success("注册成功");
    }
}
