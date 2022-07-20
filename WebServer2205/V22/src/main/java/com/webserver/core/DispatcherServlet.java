package com.webserver.core;

import com.webserver.annotations.Controller;
import com.webserver.annotations.RequestMapping;
import com.webserver.controller.ArticleController;
import com.webserver.controller.ToolsController;
import com.webserver.controller.UserController;
import com.webserver.entity.Article;
import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class DispatcherServlet {
    private static File rootDir;
    public static File staticDir;
    private static DispatcherServlet servlet; //单例模式

    static {
        servlet = new DispatcherServlet();

        try {
            //定位到：target/classes
            rootDir = new File(DispatcherServlet.class.getClassLoader().getResource(".").toURI());

            File dir = new File(rootDir, "com/webserver/controller");

            //定位static目录
            staticDir = new File(rootDir, "static");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static DispatcherServlet getInstance() {
        return servlet;
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //2：处理请求
        /*
            MAVEN项目的结构特点：
            src/main/java下存放的是项目中所有源代码，只有.java文件才能放在这里
            src/main/resources下存放的是项目中所用到的所有资源文件（非.java文件都算资源文件）
            当MAVEN项目编译后，会生成target/classes目录，并将java和resources中的内容都合并放到target/classes目录中。
            而JVM运行起来后执行的都是target/classes目录中的内容，因此该目录可以理解为是我们项目的根目录。
            若想定位这个目录，可以使用：
            类名.class.getClassLoader.getResources(".")
            这里的类名指的是在哪个类中需要定位这个目录，就写这个类名即可。

            测试将target/classes/static目录下的index.html页面给浏览器发送回去。
         */

        //定位index.html页面
        String path = request.getRequestURI();

        try {
            File dir = new File(rootDir, "com/webserver/controller");
            File[] subs = dir.listFiles(f -> f.getName().endsWith(".class"));
            String packageName = "com.webserver.controller";
            for (File sub : subs) {
                Class cls = Class.forName(packageName + "." + sub.getName().split("\\.")[0]);
                if (cls.isAnnotationPresent(Controller.class)) {
                    Object obj = cls.newInstance();
                    Method[] methods = cls.getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            RequestMapping rm = method.getAnnotation(RequestMapping.class);
                            if (path.equals(rm.value())) {
                                method.invoke(obj, request, response); //记得传参
                                return;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        File file = new File(staticDir, path);
        System.out.println("该页面是否存在：" + file.exists());

            /*
               通过socket获取输出流给浏览器发送一个标准的HTTP响应，并在响应中包含index页面内容让浏览器接收后呈现出来。
               响应内容:
               HTTP/1.1 200 OK(CRLF)
               Content-Type: text/html(CRLF)
               Content-Length: 2546(CRLF)(CRLF)
               1011101010101010101......(index.html页面的所有字节)
             */
        if (file.isFile()) { //isFile()会先判断是否存在并且是个文件
            response.setContentFile(file);
        } else {
            response.setStatusCode(404);
            response.setStatusReason("NotFound");
            response.setContentFile(new File(staticDir, "/root/404.html"));
        }
        //测试添加其他头
        response.addHeader("Server", "WebServer");
    }
}

    /*public static void main(String[] args) throws IOException {
        File file = new File("image.png"); //js不认识
        String str = Files.probeContentType(file.toPath());
        System.out.println(str);
    }*/
