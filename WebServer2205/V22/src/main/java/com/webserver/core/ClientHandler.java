package com.webserver.core;

import com.webserver.http.EmptyRequestException;
import com.webserver.http.HttpServletRequest;
import com.webserver.http.HttpServletResponse;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
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
            try {
                DispatcherServlet.getInstance().service(request, response);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }

            //3：发送响应
            response.response();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EmptyRequestException e) {

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
