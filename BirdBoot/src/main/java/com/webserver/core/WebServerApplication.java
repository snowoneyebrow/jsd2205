package com.webserver.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//WebServer主类
public class WebServerApplication {
    private ServerSocket serverSocket;
    private ExecutorService threadPool;
    protected static Class BootClass; //启动类的类对象

    public WebServerApplication() { //构造方法
        try {
            System.out.println("正在启动服务端...");
            serverSocket = new ServerSocket(8088);
            threadPool = Executors.newFixedThreadPool(50);
            System.out.println("服务端启动完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                System.out.println("等待客户端链接...");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端链接了！");

                //启动一个线程处理与该客户端的交互
                ClientHandler handler = new ClientHandler(socket); //同包类不需要import
                threadPool.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run(Class cls, String[] args) {
        BootClass = cls;
        WebServerApplication application = new WebServerApplication();
        application.start();
    }
}
