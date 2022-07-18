package com.tedu.myboot.controller;

import com.tedu.myboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 处理与用户相关的业务操作
 * <p>
 * Spring MVC框架要求，只有被注解@Controller标注的类才会被识别
 * 且对应的方法上有@RequestMapping的注解才会处理某个来自前端页面的请求。
 */
@Controller
public class UserController {
    private static File userDir; //该目录用于保存所有注册用户文件（一堆的.obj文件）

    static {
        userDir = new File("./users");
        if (!userDir.exists()) { //若该目录不存在则创建
            userDir.mkdirs();
        }
    }

    @RequestMapping("/regUser")
    //括号中的参数值应当与特定的请求一致（比如和某页面的form表单action一致）
    //<form action="/regUser" method="get">
    public void reg(HttpServletRequest request, HttpServletResponse response) { //请求，响应
        System.out.println("开始处理用户的注册操作！");

        /*
            request：请求
            parameter：参数
            该方法可以获取浏览器传递过来的参数。
            对于页面表单而言，这里调用getParameter时指定的名字必须和页面表单上对应的输入框中name属性的值一致！
         */
        //对应reg.html页面表单中<input name="username" type="text">
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        String age = request.getParameter("age");
        System.out.println(username + "," + password + "," + nickname + "," + age);

        //对数据进行必要的验证工作
        if (username == null || password == null || nickname == null || age == null
                || username.isEmpty() || password.isEmpty() || nickname.isEmpty() || age.isEmpty()
                || !age.matches("\\d+")) { //0-9
            //若任何上述情况，则直接响应给用户一个注册失败提示页面，告知信息输入有误。
            try {
                response.sendRedirect("/reg_info_error.html");
                return; //出错了直接结束，不走下面的代码
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //处理注册
        //将年龄转换为int值
        int age_ = Integer.parseInt(age);
        User user = new User(username, password, nickname, age_);

        //File()方法，参数1：当前File表示的文件所在的目录，参数2：当前文件的名字
        File userFile = new File(userDir, username + ".obj");
        if (userFile.exists()) { //文件已经存在说明该用户已经存在
            try {
                response.sendRedirect("/have_user.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        try ( //
              FileOutputStream fos = new FileOutputStream(userFile);
              ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) { //
            oos.writeObject(user);
            response.sendRedirect("/reg_success.html"); //响应注册成功页面给浏览器
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/loginUser")
    public void login(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始处理用户的登录操作！");

        /*
            1：从request中将表单中用户输入的用户名和密码获取
            2：必要的验证工作（两项内容都不能为空）
              若有空的情况，直接响应页面：login_info_error.html
              提示：登录信息输入有误，请重新登录
            3：根据该用户的用户名读取对应的obj文件
              进行反序列化，并将得到的User对象和该登录用户输入的用户名和密码比对
              若比对成功则响应登录成功页面：login_success.html
              提示：登录成功，欢迎回来!
              若比对失败则响应登录失败页面：login_fail.html
              提示：用户名或密码错误，请重新登录。
         */
        //获取用户的登录信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.isEmpty() || password.isEmpty()) { //不能写==null
            try {
                response.sendRedirect("/login_info_error.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            }
        }

        //登录失败
        try {
            response.sendRedirect("/login_fail.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/userList")
    public void userList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("开始处理显示用户列表！");

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
                System.out.println(user);
                userList.add(user);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            response.setContentType("text/html;charset=utf-8");
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
                //<td><a href='/deleteUser?username=xxxxx'>删除</a></td>
                pw.println("<td><a href=\"/deleteUser?username=" + user.getUsername() + "\">删除</a></td>");
                pw.println("</tr>");
            }

            pw.println("</table>");
            pw.println("</center>");
            pw.println("</body>");
            pw.println("</html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/deleteUser")
    public void delete(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        System.out.println("要删除的用户是:" + username);
        //根据用户名定位users目录下对应的obj文件，将该文件删除
        File userFile = new File(userDir, username + ".obj");
        if (userFile.exists()) {
            System.out.println(userFile.getName());
            userFile.delete();
        }

        try {
            response.sendRedirect("/userList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
