package com.tedu.boot.controller;

import com.tedu.boot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @RequestMapping("/regUser")
    //1、传request
    //2、public void reg(String username, String password, String nickname, int age, HttpServletResponse response) {
    //3、
    public void reg(User user, HttpServletResponse response) {
        System.out.println("开始处理用户注册！");
        System.out.println(user.getUsername() + "," + user.getPassword() + "," + user.getNickname() + "," + user.getAge());
    }
}
