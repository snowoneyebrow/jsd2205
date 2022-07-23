package io;

import java.io.FileInputStream;
import java.io.IOException;

//使用文件输入流从文件中读取字节数据
public class FISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./fos.txt");

        /*
        InputStream上定义了所有字节输入流都必须具备的读取操作：
        int read()：
        从流中读取一个字节，返回的int值只有“低八位”有效。
        但是如果返回的int值为整数-1，则表示流读取到了末尾。
        （不能再通过这个流读取到任何数据了）
         */

        /*
        fos.dat文件中的数据:
        00000001 00000010

        当我们第一次调用文件输入流的读取字节操作：
        int d = fis.read();

        00000001 00000010
        ^^^^^^^^
        读取的字节

        int d接收的返回值2进制的样子：
        00000000 00000000 00000000 00000001
        |-----会固定补充24个0------| 读取的字节
         */
        int d = fis.read();
        System.out.println(d);

        //当我们第二次调用文件输入流的读取字节操作：（和第一次相同）
        d = fis.read();
        System.out.println(d);

        /*
        当我们第三次调用文件输入流的读取字节操作：
        d = fis.read();

        00000001 00000010
                          ^^^^^^^^
                          文件末尾

        int d接收的返回值2进制的样子：
        11111111 11111111 11111111 11111111
        -1是一个特殊值，这是用正常读取一个字节永远表达不了的2进制样子来表示文件末尾
         */
        d = fis.read();
        System.out.println(d);

        fis.close();
    }
}
