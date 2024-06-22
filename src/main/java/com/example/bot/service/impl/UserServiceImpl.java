package com.example.bot.service.impl;

import com.example.bot.mapper.UserMapper;
import com.example.bot.model.User;
import com.example.bot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
