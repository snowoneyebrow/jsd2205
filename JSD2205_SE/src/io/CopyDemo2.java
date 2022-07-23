package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
提高每次读写的数据量，减少实际读写的次数，可以提高读写效率。
单字节读写是一种随机读写形式，一组字节的读写是块读写形式。
利用块读写形式可以提高读写效率。
 */
public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./123.png");
        FileOutputStream fos = new FileOutputStream("./123_copy.png");

        /*
        java.io.InputStream上定义了块读取字节的操作：
        int read(byte[] data)：
        一次性从流中读取给定的字节数组data的长度的字节量，并存入该字节数组中。
        返回的int值表达的是本次实际读取到的数据量。
        如果返回的int值为整数-1，则表示本次已经是流的末尾了，没有读取到任何数据。

        假设ppt.pptx中的文件内容：
        11001100 00110011 11110000 00001111 10101010 01010101

        int d = 0;
        byte[] data = new byte[4]; //长度为4的字节数组

        背景知识：
        byte、short、int、long都表示整数，区别是什么？
        byte是1个字节，对应的2进制是00000000（8位2进制）
        short是2个字节，对应的2进制是00000000 00000000
        int是4个字节，
        long是8个字节。

        读取前：
        d的值是整数：0（10进制的样子）
        data数组中每个整数2进制的样子：{00000000,00000000,00000000,00000000} //默认都是0

        第一次调用：
        d = fis.read(data);
        因为data数组长度为4，意味着read()方法可以一次性读取4个字节
        文件内容：
        11001100 00110011 11110000 00001111 10101010 01010101
        ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
        连续读取的4个字节
        读取后会将读取到的4个字节存入到data数组中。因此变量内容的变化：
        d的值是整数：4，表示本次实际读取到了4个字节
        data数组中每个整数2进制的样子：{11001100,00110011,11110000,00001111}

        第二次调用:
        d = fis.read(data);
        因为data数组长度为4，意味着read()方法可以一次性读取4个字节
        文件内容：
        11001100 00110011 11110000 00001111 10101010 01010101
                                            ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
                                            实际只能读取2个字节  |---文件末尾了----|
        连续读取4个字节，但实际只读取到了2个字节
        读取后会将读取到的2个字节存入到data数组中。因此变量内容的变化：
        d的值是整数：2，表示本次实际读取到了2个字节
        data数组中每个整数2进制的样子：{10101010,01010101,11110000,00001111}
                                   |本次实际读取的字节|  |---上次的旧数据---|

        第三次调用：
        d = fis.read(data);
        因为data数组长度为4，意味着read()方法可以一次性读取4个字节
        文件内容：
        11001100 00110011 11110000 00001111 10101010 01010101
                                                              ^^^^^^^^ ^^^^^^^^ ^^^^^^^^ ^^^^^^^^
                                                              文件末尾了
        连续读取4个字节，但实际没有读取到任何数据（文件已经读到末尾了）
        因此变量内容的变化：
        d的值是整数：-1，表示本次已经是文件末尾了
        data数组中每个整数2进制的样子：{10101010,01010101,11110000,00001111}
                                   数组没有变化，都是旧数据

        java.io.OutputStream上定义了所有字节输出流都必须具备的块写操作：
        void write(byte[] data)：
        一次性将给定的字节数组的所有字节写出。

        void write(byte[] data,int offset,int len)
        一次性将给定的data数组从下标offset处开始的连续len个字节写出
         */

        int d = 0;
        byte[] data = new byte[1024 * 10]; //10kb
        long start = System.currentTimeMillis();
        while ((d = fis.read(data)) != -1) { //传参：data数组
            fos.write(data, 0, d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时" + (end - start) + "ms");

        fis.close();
        fos.close();
    }
}
