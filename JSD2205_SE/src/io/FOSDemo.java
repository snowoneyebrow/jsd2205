package io;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JAVA IO：
 * IO：Input，Output，即：输入与输出
 * JAVA IO使程序可以和外界交换数据，用于对外界数据进行读写操作。
 *
 * java将输入与输出比喻为“流”：stream
 * 如何理解流：将流想象为一个连接程序和另一端的“管道”，在其中按照同一方向顺序移动的数据。
 * 有点像“水管”中向同一方向流动的水。
 * 输入流：从外界向我们的程序中移动的方向，是用来获取数据的流，作用是：读取操作
 * 输出流：写出操作
 * 注意：流是单向的，输入流永远只用来读，输出流永远只用来写。
 * 将来我们在实际开发中希望与程序交互的另一端互相发送数据时，
 * 只需要创建一个可以连接另一端的“流”，进行读写操作即可。
 *
 * java定义了两个超类，来规范所有的字节流：
 * java.io.InputStream：所有字节输入流的超类（抽象类），里面定义了读取字节的相关方法，所有字节输入流都继承自它。
 * java.io.OutputStream：所有字节输出流的超类（抽象类），里面定义了写出字节的相关方法，所有字节输出流都继承自它。
 *
 * 文件流：
 * java.io.FileInputStream和java.io.FileOutputStream
 * 是真实连接我们程序和文件之间的“管道”。
 * 其中文件输入流用于从文件中读取字节，而文件输出流则用于向文件中写入字节。
 *
 * 文件流是节点流。
 * JAVA IO将流划分为两类：节点流和处理流
 *
 * 节点流：俗称“低级流”，特点：真实连接我们程序和另一端的“管道”，负责实际读写数据的流。
 * 文件流就是典型的节点流，真实连接我们程序与文件的“管道”，可以读写文件数据。
 *
 * 处理流：俗称"高级流"
 * 特点：
 * 1：不能独立存在（不可以单独实例化进行读写操作）
 * 2：必须连接在其他流上，目的是当数据"流经"当前流时，可以对其做某种加工操作，简化我们的工作、
 * 流的连接:实际开发中经常会串联一组高级流最终到某个低级流上，对数据进行流水线式的加工读写。
 *
 */
public class FOSDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("./fos.dat");
        //File file=new File("./fos.dat");
        //FileOutputStream fos=new FileOutputStream(file);
        fos.write(48); //0
        fos.write(65); //A
        fos.write(97); //a
        System.out.println("写出完毕");
        fos.close();
    }
}
