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
