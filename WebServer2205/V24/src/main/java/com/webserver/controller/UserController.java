package com.webserver.controller;

import com.webserver.annotations.Controller;
import com.webserver.annotations.RequestMapping;
import com.webserver.entity.User;
import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    private static File userDir;

    static {
        userDir = new File("./users");
        if (!userDir.exists()) { //如果不存在
            userDir.mkdirs();
        }
    }

    @RequestMapping("/regUser")
    public void reg(String username, String password, String nickname, int age, HttpServletResponse response) {
        System.out.println("开始处理用户注册！");


        System.out.println(username + "," + password + "," + nickname + "," + age);


    }

    @RequestMapping("/userList")
    public void userList(HttpServletRequest request, HttpServletResponse response) {
        logger.info("开始处理动态页面！");

        //创建一个List集合保存所有的User对象
        List<User> userList = new ArrayList<>();
        /*
            将users目录下的所有obj文件获取回来，并进行反序列化操作，
            得到所有的User对象并存入到userList集合备用
         */
        File[] subs = userDir.listFiles(f -> f.getName().endsWith(".obj"));
        for (File sub : subs) {
            try (
                    FileInputStream fis = new FileInputStream(sub);
                    ObjectInputStream ois = new ObjectInputStream(fis);
            ) {
                User user = (User) ois.readObject();
                logger.debug("user：" + user);
                userList.add(user);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                logger.error(e.getMessage(), e);
            }
        }

        PrintWriter pw = response.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html lang=\"en\">");
        pw.println("<head>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<title>用户列表</title>");
        pw.println("</head>");
        pw.println("<body style=\"background:url('/52793674_p0.jpg') no-repeat center fixed;background-size:contain;\">");
        pw.println("<center>");
        pw.println("<h1 style=\"color:#E50080\">用户列表</h1>");
        pw.println("<table border=\"2\" bgcolor=\"#FE91CC\">");
        pw.println("<tr>");
        pw.println("<td>用户名</td>");
        pw.println("<td>密码</td>");
        pw.println("<td>昵称</td>");
        pw.println("<td>年龄</td>");
        pw.println("</tr>");

        for (User user : userList) {
            pw.println("<tr>");
            pw.println("<td>" + user.getUsername() + "</td>");
            pw.println("<td>" + user.getPassword() + "</td>");
            pw.println("<td>" + user.getNickname() + "</td>");
            pw.println("<td>" + user.getAge() + "</td>");
            pw.println("<td><a href=\"/deleteUser?username=" + user.getUsername() + "\">删除</a></td>");
            pw.println("</tr>");
        }

        response.setContentType("text/html;charset=utf-8");

        pw.println("</table>");
        pw.println("</center>");
        pw.println("</body>");
        pw.println("</html>");
    }

    @RequestMapping("/loginUser")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) { //不能写==null
            response.sendRedirect("/login_info_error.html");
            return;
        }

        File userFile = new File(userDir, username + ".obj");
        if (userFile.exists()) { //文件存在则说明用户名输入正确
            //反序列化该文件中之前的注册信息
            try (
                    FileInputStream fis = new FileInputStream(userFile);
                    ObjectInputStream ois = new ObjectInputStream(fis)
            ) {
                User user = (User) ois.readObject();

                //密码正确
                if (user.getPassword().equals(password)) { // && username.equals(p.getUsername())不用写
                    //登录成功
                    response.sendRedirect("/login_success.html");
                    return;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                logger.error(e.getMessage(), e);
            }
        }

        //登录失败
        response.sendRedirect("/login_fail.html");
    }

    @RequestMapping("/deleteUser")
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        logger.info("开始处理删除用户动作！");
    }

    /*public static void main(String[] args) {
        System.out.println(ClientHandler.class.getClass().getResource("/").getPath());
    }*/
}
