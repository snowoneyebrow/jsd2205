package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/*
缓冲字符流：
java.io.BufferedWriter、java.io.BufferedReader
缓冲字符流是一对字符流，且是一对高级流。作用是提高读写文本数据的效率。
内部默认维护一个8k长度的char数组（注意，不是8kb！是一个8192长度的char数组）

java.io.PrintWriter是具有自动行刷新功能的缓冲字符输出流。
其内部总是链接着BufferedWriter，并且可以按行写出字符串。
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        /*
        支持直接对文件写操作的构造器：
        PrintWriter(File file)
        PrintWriter(String path)
        上述构造器内部会进行四层流连接完成对文件的写出操作
        详见代码下方图片：PW.png

        重载构造器（推荐）：
        PrintWriter(File file,String csn)
        PrintWriter(String path,String csn)
        支持用第二个参数来指定字符集的名称
        不理想的地方：字符集的名称需要用字符串自行指定
         */

        //向文件中写入文本数据
        PrintWriter pw = new PrintWriter("./pw.txt", "UTF-8");
        //或者：String.valueOf(StandardCharsets.UTF_8)

        pw.println("test123");
        pw.println("371vdsvc");
        System.out.println("写出完毕");

        pw.close();
    }
}
