package com.webserver.core;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            String line = readLine();
            System.out.println("请求行：" + line);

            String method;   //请求方式
            String uri;      //抽象路径
            String protocol; //协议版本

            String[] data = line.split("\\s"); //空格或\s
            //请求行相关信息
            method = data[0];   //请求方式
            uri = data[1];      //抽象路径
            protocol = data[2]; //协议版本
            //测试路径：http://localhost:8088/index.html

            System.out.println("method:" + method);     //method:GET
            System.out.println("uri:" + uri);           //uri:/index.html
            System.out.println("protocol:" + protocol); //protocol:HTTP/1.1

            Map<String, String> headers = new HashMap<>();
            while (true) {
                line = readLine();
                if (line.isEmpty()) { //读到最后一行，不能写==null
                    break;
                }
                System.out.println("消息头：" + line);

                String[] data1=line.split(":\\s"); //冒号空格
                headers.put(data1[0],data1[1]);
            }
            System.out.println("headers:"+headers);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //被重用的代码都不处理异常
    private String readLine() throws IOException {
        InputStream in = socket.getInputStream();
        int d;
        char cur = 'a', pre = 'a'; //cur：本次，pre：上次
        StringBuilder builder = new StringBuilder();
        while ((d = in.read()) != -1) {
            cur = (char) d;
            if (pre == 13 && cur == 10) { //pre == '\r' && cur == '\n'
                break;
            }
            builder.append(cur);
            pre = cur;
        }
        return builder.toString().trim();
    }
}
