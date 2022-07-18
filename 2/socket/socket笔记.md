![网络IO](.\网络IO.png)

<div style="page-break-after: always;"></div>

# Client
```java
package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//聊天室客户端
public class Client {
    /*
        java.net.Socket 套接字：
        Socket封装了TCP协议的通讯细节，我们使用它就可以和服务端建立链接并
        基于两条流的读写操作完成与远端计算机的交互。
        我们可以把Socket想象为"电话"。
     */
    private Socket socket;

    public Client() {
        try {
            /*
                Socket提供的常用构造器：
                Socket(String host,int port)
                通过给定的IP地址和端口与远端计算机建立TCP链接。
                参数1：远端计算机的IP地址信息
                参数2：远端计算机打开的服务端口
                我们可以通过IP找到网络上的该计算机，通过端口找到运行在该计算机上的服务端应用程序
             */
            System.out.println("正在链接服务端...");
            socket = new Socket("localhost", 8088);
            //端口：0-65535（前6000基本不要用，8000以后随便用），localhost：本机
            System.out.println("与服务端建立链接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            /*
                Socket中非常重要的一个方法：
                OutputStream getOutputStream()：
                该方法返回一个字节输出流，使用该流写出的字节会发送给远端链接的计算机
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw, true);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请输入文字，输入exit退出：");
                String line = scanner.nextLine();
                if ("exit".equals(line)) {
                    System.out.println("客户端主动退出");
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                //最终调用socket.close()与服务端进行TCP的挥手断开操作。
                //关闭socket的同时，通过socket获取的输入流或输出流也就自动关闭了
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}
```

<div style="page-break-after: always;"></div>

# Server
```java
package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//聊天室服务端
//先启动服务端，再启动客户端
public class Server {
    /*
        java.net.ServerSocket：
        运行在服务端的ServerSocket主要负责两个工作：
        1：申请服务端口，客户端通过该端口与服务端建立链接
        2：听服务端口，一旦一个客户端链接便创建一个Socket与该客户端交互

        ServerSocket相当于是客服的"总机"
     */
    private ServerSocket serverSocket;

    public Server() {
        try {
            System.out.println("正在启动服务端...");
            serverSocket = new ServerSocket(8088);
            /*
                java.net.BindException: address already in use
                原因：服务端申请的端口被系统其它程序占用了。
                解决办法：
                1：后期遇到该问题通常是重复启动了两次服务端导致的，需要杀死之前启动的
                  服务端进程
                2：更换端口号
             */
            System.out.println("服务端启动完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            System.out.println("等待客户端链接...");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端链接了！");

            /*
                Socket中重要的一个方法：
                InputStream getInputStream()：
                通过socket获取的字节输入流可以读取建立链接的远端计算机发送过来的字节
             */
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            /*
                这里我们使用BufferedReader的readLine试图读取来自远端计算机
                发送过来的一行字符串时，如果对方链接还保持着，但是没有发送任何
                内容时，这里的readLine会阻塞。

                客户端断开链接时，服务端的readLine方法可能出现以下几种情况：
                最正常的情况：客户端调用socket的close方法与服务端断开链接
                socket的close方法会进行底层TCP的挥手动作与对方断开链接。
                那么readLine方法会立即返回null，表示链接断开了，不能再读取数据了

                客户端若异常断开链接，没有调用socket.close()就结束程序了，那么
                服务端这里的readLine()方法会抛出异常：
                java.net.SocketException: Connection reset
             */
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("客户端说：" + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
```

<div style="page-break-after: always;"></div>

![聊天室多线程](.\聊天室多线程.png)

<div style="page-break-after: always;"></div>

# Server_V2
```java
package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

//聊天室服务端V2
public class Server_V2 {
    /*
        java.net.ServerSocket：
        运行在服务端的ServerSocket主要负责两个工作：
        1：申请服务端口，客户端通过该端口与服务端建立链接
        2：听服务端口，一旦一个客户端链接便创建一个Socket与该客户端交互
     */
    private ServerSocket serverSocket;

    public Server_V2() {
        try {
            System.out.println("正在启动服务端...");
            serverSocket = new ServerSocket(8088);
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

                //启动一个线程来处理与该客户端的交互
                Runnable handler = new ClientHandler(socket); //向上造型
                Thread t = new Thread(handler); //Thread接收一个Runnable类型的参数
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server_V2 server = new Server_V2();
        server.start();
    }

    //该线程的任务是负责与指定的客户端进行交互
    private class ClientHandler implements Runnable { //成员内部类
        private Socket socket;
        private String host; //记录远端计算机的地址信息

        public ClientHandler(Socket socket) {
            this.socket = socket;
            host = socket.getInetAddress().getHostAddress(); //获取远端计算机的地址信息
        }

        public void run() { //重写Runnable接口的run()方法
            try {
                /*
                Socket中重要的一个方法：
                InputStream getInputStream()：
                通过socket获取的字节输入流可以读取建立链接的远端计算机发送过来的字节
                 */
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                /*
                这里我们使用BufferedReader的readLine试图读取来自远端计算机
                发送过来的一行字符串时，如果对方链接还保持着，但是没有发送任何
                内容时，这里的readLine会阻塞。

                客户端断开链接时，服务端的readLine方法可能出现以下几种情况：
                最正常的情况：客户端调用socket的close方法与服务端断开链接
                socket的close方法会进行底层TCP的挥手动作与对方断开链接。
                那么readLine方法会立即返回null，表示链接断开了，不能再读取数据了

                客户端若异常断开链接，没有调用socket.close()就结束程序了，那么
                服务端这里的readLine()方法会抛出异常：
                java.net.SocketException: Connection reset
                 */
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(host + "说：" + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```
