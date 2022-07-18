package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {
    private Socket socket;

    private String method;   //请求方式
    private String uri;      //抽象路径
    private String protocol; //协议版本

    private Map<String, String> headers = new HashMap<>();

    public HttpServletRequest(Socket socket) throws IOException {
        this.socket = socket;

        parseRequestLine();
        parseHeaders();
        parseContent();
    }

    private void parseRequestLine() throws IOException {
        String line = readLine();
        System.out.println("请求行：" + line);
        String[] data = line.split("\\s"); //空格或\s
        //请求行相关信息
        method = data[0];   //请求方式
        uri = data[1];      //抽象路径
        protocol = data[2]; //协议版本
        //测试路径：http://localhost:8088/index.html
    }

    private void parseHeaders() throws IOException {
        while (true) {
            String line = readLine();
            if (line.isEmpty()) { //读到最后一行，不能写==null
                break;
            }
            System.out.println("消息头：" + line);

            String[] data = line.split(":\\s"); //冒号空格
            headers.put(data[0], data[1]);
        }
        System.out.println("headers:" + headers);
    }

    private void parseContent() {

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

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHeader(String name) {
        return headers.get(name);
    }
}
