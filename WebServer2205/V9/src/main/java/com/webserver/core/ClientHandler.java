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
            HttpServletResponse response = new HttpServletResponse(socket);

            //2：处理请求
            DispatcherServlet servlet = DispatcherServlet.getInstance();
            servlet.service(request, response);

            //3：发送响应
            response.response();
        } catch (IOException e) {
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
