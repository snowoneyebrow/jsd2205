package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        //创建一个文件输入流，用来从原文件中读取每个字节
        FileInputStream fis = new FileInputStream("./123.png");

        //创建一个文件输出流，用来向复制的文件中写入每个字节
        FileOutputStream fos = new FileOutputStream("123_copy.png");

        /*
        假设image.jpg中的文件内容:
        11001100 00110011 11110000 00001111 10101010 01010101......

        第一次调用：
        int d = fis.read();

        11001100 00110011 11110000 00001111 10101010 01010101......
        ^^^^^^^^
        读取的字节

        d的2进制样子：00000000 00000000 00000000 11001100
                                               ^^^^^^^^
        fos.write(d)                           写出的字节

        写出完毕后，image_cp.jpg文件内容：
        11001100
         */
        int d = 0;
        long start = System.currentTimeMillis();
        while ((d = fis.read()) != -1) {
            fos.write(d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时" + (end - start) + "ms");

        fis.close();
        fos.close();
    }
}
