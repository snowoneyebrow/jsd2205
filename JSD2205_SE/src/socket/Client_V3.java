package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//聊天室客户端V3
public class Client_V3 {
    /*
        java.net.Socket 套接字：
        Socket封装了TCP协议的通讯细节，我们使用它就可以和服务端建立链接并
        基于两条流的读写操作完成与远端计算机的交互。
        我们可以把Socket想象为"电话"。
     */
    private Socket socket;

    public Client_V3() {
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
            //启动一个线程用来读取服务端发送过来的消息
            ServerHandler serverHandler = new ServerHandler();
            Thread t = new Thread(serverHandler);
            t.setDaemon(true); //守护线程
            t.start();

            /*
                Socket中非常重要的一个方法：
                OutputStream getOutputStream()：
                该方法返回一个字节输出流，使用该流写出的字节会发送给远端链接的计算机
             */
            //发给别人
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
        Client_V3 client = new Client_V3();
        client.start();
    }

    //该线程负责读取服务端发送过来的消息
    private class ServerHandler implements Runnable {
        public void run() {
            //接收别人
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                //有错但假装看不见
            }
        }
    }
}
