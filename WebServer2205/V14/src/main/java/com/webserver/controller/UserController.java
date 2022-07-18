package com.webserver.controller;

import com.webserver.entity.User;
import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UserController {
    private static File userDir;

    static {
        userDir = new File("./users");
        if (!userDir.exists()) { //如果不存在
            userDir.mkdirs();
        }
    }

    public void reg(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始处理用户注册！");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        String age = request.getParameter("age");
        System.out.println(username + "," + password + "," + nickname + "," + age);

        //对数据进行必要的验证工作
        if (username.isEmpty() || password.isEmpty() || nickname.isEmpty() || age.isEmpty() ||
                !age.matches("[0-9]+")) {
            //如果如何上述情况，则直接响应给用户一个注册失败提示页面，告知信息输入有误。
            response.sendRedirect("/reg_info_error.html");
            return;
        }

        //处理注册
        //将年龄转换为int值
        int age_ = Integer.parseInt(age);
        User user = new User(username, password, nickname, age_);

        //参数1:当前File表示的文件所在的目录  参数2:当前文件的名字
        File userFile = new File(userDir, username + ".obj");
        if (userFile.exists()) {//文件已经存在说明该用户已经存在了!
            response.sendRedirect("/have_user.html");
            return;
        }

        try (
                FileOutputStream fos = new FileOutputStream(userFile);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(user);
            //响应注册成功页面给浏览器
            response.sendRedirect("/reg_success.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
