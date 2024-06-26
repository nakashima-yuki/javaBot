package com.example.bot.service.impl;

import com.example.bot.mapper.UserMapper;
import com.example.bot.model.User;
import com.example.bot.service.UserService;
import com.example.bot.utils.PasswordTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public void regiser(String email, String password) {
        // 密码加密
        String salt = UUID.randomUUID().toString().replaceAll("-", "");
        password = PasswordTools.encrypt(password,salt);

        userMapper.add(email,password,salt);
    }
}
