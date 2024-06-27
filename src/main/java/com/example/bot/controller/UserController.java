package com.example.bot.controller;

import com.auth0.jwt.interfaces.Claim;
import com.example.bot.model.Result;
import com.example.bot.model.User;
import com.example.bot.service.UserService;
import com.example.bot.utils.JwtUtil;
import com.example.bot.utils.PasswordTools;
import com.example.bot.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/getUserInfo")
    public Result getUserInfo() {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = Integer.parseInt(map.get("id").toString());
        return Result.success(userService.findById(id));
    }

    @PostMapping("/register")
    public Result register(String email, String password) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return Result.error("该邮箱已注册!");
        }

        userService.regiser(email, password);

        return Result.success("注册成功");
    }

    @PostMapping("/login")
    public Result login(String email, String password) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return Result.error("用户不存在");
        }
        String md5Password = PasswordTools.encrypt(password, user.getSalt());
        if (md5Password.equals(user.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            String token = JwtUtil.generateToken(claims);
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            ops.set("user:" + user.getId(),token,7, TimeUnit.HOURS);
            return Result.success(token);
        }

        return Result.error("用户名或密码错误");
    }
}
