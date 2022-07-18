package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpServletResponse {
    private Socket socket;

    private int statusCode = 200; //状态代码
    private String statusReason = "OK"; //状态描述

    //响应头相关信息
    private Map<String, String> headers = new HashMap<>(); //存所有响应头

    private File contentFile;

    public HttpServletResponse(Socket socket) {
        this.socket = socket;
    }

    public void response() throws IOException {
        sendStatusLine(); //3.1发送状态行

        sendHeaders(); //3.2发送响应头

        sendContent(); //3.3发送响应正文（index.html页面中的所有字节）
    }

    private void sendStatusLine() throws IOException {
        println("HTTP/1.1" + " " + statusCode + " " + statusReason);
    }

    private void sendHeaders() throws IOException {
        Set<Map.Entry<String, String>> entrySet = headers.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            String name = e.getKey();
            String value = e.getValue();
            println(name + ": " + value);
        }

        //单独发送一组回车+换行表示响应头部分发送完了
        println("");
    }

    private void sendContent() throws IOException {
        //先获取index.html的内容，再发送到浏览器
        try (
                FileInputStream fis = new FileInputStream(contentFile);
        ) {
            OutputStream out = socket.getOutputStream();

            int len;
            byte[] data = new byte[1024 * 10];
            while ((len = fis.read(data)) != -1) {
                out.write(data, 0, len); //CopyDemo2.java
            }
        } //使用finally特性，关掉上面的fis
    }

    private void println(String line) throws IOException {
        OutputStream out = socket.getOutputStream();
        out.write(line.getBytes(StandardCharsets.ISO_8859_1)); //转为二进制发送
        out.write(13); //发送回车符
        out.write(10); //发送换行符
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public File getContentFile() {
        return contentFile;
    }

    public void setContentFile(File contentFile) {
        this.contentFile = contentFile;
    }

    public void addHeader(String name, String value) {
        headers.put(name, value);
    }
}
