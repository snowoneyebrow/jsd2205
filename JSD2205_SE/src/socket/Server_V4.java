package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

//聊天室服务端V4
public class Server_V4 {
    /*
        java.net.ServerSocket：
        运行在服务端的ServerSocket主要负责两个工作：
        1：申请服务端口，客户端通过该端口与服务端建立链接
        2：听服务端口，一旦一个客户端链接便创建一个Socket与该客户端交互
     */
    private ServerSocket serverSocket;

    private ArrayList<PrintWriter> allOut = new ArrayList<>(); //客户端数组

    public Server_V4() {
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
        Server_V4 server = new Server_V4();
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
            PrintWriter pw = null;

            try {
                /*
                Socket中一个重要的方法：
                InputStream getInputStream()：
                通过socket获取的字节输入流可以读取建立链接的远端计算机发送过来的字节
                 */
                //接收别人
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr);

                //发给别人
                OutputStream out = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                BufferedWriter bw = new BufferedWriter(osw);
                pw = new PrintWriter(bw, true); //println自动行刷新

                //没有新复制一个数组的相关操作，所以可以用自身
                synchronized (allOut) {
                    allOut.add(pw);
                }
                sendMessage(host + "上线了，当前在线人数：" + allOut.size());

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
                    sendMessage(host + "说：" + line);
                }
            } catch (IOException e) {
                //当客户端强行关闭，服务端readline会抛出异常，这里可以catch异常
            } finally {
                //将当前pw从allOut数组中删除
                synchronized (allOut) {
                    allOut.remove(pw);
                }
                System.out.println(host + "下线了，当前在线人数：" + allOut.size());
            }

            try {
                socket.close(); //关闭socket释放底层资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //广播消息给每一个客户端
        private void sendMessage(String line) {
            System.out.println(host + "说：" + line);
            synchronized (allOut) {
                for (PrintWriter pw : allOut) {
                    pw.println(host + "说：" + line);
                }
            }
        }
    }
}
