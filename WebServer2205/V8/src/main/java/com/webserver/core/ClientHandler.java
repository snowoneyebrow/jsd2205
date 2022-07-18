package com.webserver.core;

import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.*;
import java.net.Socket;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

/**
 * 处理一次与客户端的HTTP交互操作
 * 处理一次HTTP交互由三步完成：
 * 1：解析请求
 * 2：处理请求
 * 3：发送响应
 */
public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) { //构造方法
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //1：解析请求
            HttpServletRequest request = new HttpServletRequest(socket);

            HttpServletResponse response=new HttpServletResponse(socket);

            //2：处理请求

            //3：发送响应
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
            //定位到：target/classes
            File rootDir = new File(ClientHandler.class.getClassLoader().getResource(".").toURI());

            //定位static目录
            File staticDir = new File(rootDir, "static");

            //定位index.html页面
            //File file = new File(staticDir, "index.html");
            String path = request.getUri();
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

            response.response();

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); //通过socket获取的输入流和输出流都关了
                //类似于电话，直接把电话都拿走了
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
