package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求对象：
 * 该类的每一个实例用于表示浏览器发送过来的一个HTTP的请求内容
 * 每个请求HTTP协议要求由三部分构成：请求行，消息头，消息正文
 */
public class HttpServletRequest {
    private Socket socket;

    //请求行相关信息
    private String method;   //请求方式
    private String uri;      //抽象路径
    private String protocol; //协议版本

    private String requestURI;
    private String queryString;

    private Map<String, String> parameters = new HashMap<>();

    //消息头相关信息
    private Map<String, String> headers = new HashMap<>();

    public HttpServletRequest(Socket socket) throws IOException, EmptyRequestException { //构造方法
        this.socket = socket;

        //1.1解析请求行
        parseRequestLine();
        //1.2:解析消息头
        parseHeaders();

        parseURI();

        //1.3:解析消息正文
        parseContent();
    }

    //解析请求行
    private void parseRequestLine() throws IOException, EmptyRequestException {
        String line = readLine();

        if (line.isEmpty()) {
            throw new EmptyRequestException();
        }

        System.out.println("请求行：" + line);
        String[] data = line.split("\\s"); //空格或\s
        //请求行相关信息
        method = data[0];
        uri = data[1];
        //这里可能出现数组下标越界，这是因为浏览器发送了空请求导致的。后期会解决。现在出现该异常先忽略。重新启动服务端重新测试。
        protocol = data[2];
        //测试路径：http://localhost:8088/index.html
    }

    private void parseURI() {
        String[] data = uri.split("\\?");
        requestURI = data[0]; //情况：/reg.html，/regUser?
        if (data.length > 1) {
            queryString = data[1];
            parseParameters(queryString);
        }

        System.out.println("requestURI: " + requestURI);
        System.out.println("queryString: " + queryString);
        System.out.println("parameters: " + parameters);
    }

    //解析参数，username=...&password=...&...
    private void parseParameters(String line){
        String[] data = line.split("&");
        for (String para : data) {
            String[] paras = para.split("=");
            parameters.put(paras[0], paras.length > 1 ? paras[1] : "");
        }
    }

    //解析消息头
    private void parseHeaders() throws IOException {
        while (true) {
            String line = readLine();
            if (line.isEmpty()) { //读到最后一行，不能写==null
                //如果readLine返回空字符串，说明单独读取到了回车+换行
                break;
            }
            System.out.println("消息头：" + line);

            /*
                将每一个消息头按照": "(冒号+空格拆)分为消息头的名字和消息头的值
                并以key，value的形式存入到headers中
             */
            String[] data = line.split(":\\s"); //冒号空格
            //将浏览器发送的消息头的名字转为全小写，兼容性更好
            headers.put(data[0].toLowerCase(), data[1]);
        }//while循环结束，消息头解析完毕
        System.out.println("headers:" + headers);
    }

    //解析消息正文
    private void parseContent() throws IOException {
        //判断本次请求方式是否为post
        if ("POST".equalsIgnoreCase(method)) {
            //根据消息头content-length来确定正文的字节数
            String contentLength = getHeader("content-length");
            if (contentLength != null) {
                int length = Integer.parseInt(contentLength);
                System.out.println("正文长度：" + length);
                byte[] data = new byte[length];
                InputStream in = socket.getInputStream();
                in.read(data);
                //根据content-type来判断正文类型
                String contentType = getHeader("content-type");
                //判断类型是否为form表单不带附件的数据
                if ("application/x-www-form-urlencoded".equals(contentType)) {
                    String line = new String(data, StandardCharsets.ISO_8859_1);
                    System.out.println("正文内容：" + line);
                    parseParameters(line);
                }
                //else if
            }
        }
    }

    //通常被重用的代码都不自己处理异常
    private String readLine() throws IOException {
        //同一个socket对象无论调用多少次getInputStream()获取的始终是同一个输入流
        InputStream in = socket.getInputStream();
        int d; //每次读取到的字节
        char cur = 'a', pre = 'a'; //cur表示本次读取到的字符，pre表示上次读取到的字符
        StringBuilder builder = new StringBuilder(); //String不适合频繁修改操作
        while ((d = in.read()) != -1) {
            cur = (char) d;
            if (pre == 13 && cur == 10) {
                //pre == '\r' && cur == '\n'
                //是否已经连续读取到了回车+换行符
                break;
            }
            builder.append(cur);
            pre = cur;
        }
        return builder.toString().trim(); //builder.toString()最后有一个回车符，需要用trim()去除字符串两边的空白字符
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
        return headers.get(name.toLowerCase());
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getParameter(String name) {
        return parameters.get(name); //name作为key，提取value
    }
}
