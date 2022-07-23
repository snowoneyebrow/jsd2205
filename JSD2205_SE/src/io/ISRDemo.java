package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

//使用转换输入流读取文本数据
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        //将当前源代码输出到控制台上
        FileInputStream fis = new FileInputStream("./src/io/ISRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);

        /*
        字符流java.io.Reader上提供了所有字符输入流都应具备的读取字符的方法：
        int read()：
        一次读取一个字符，返回的int值实际上表示一个char
        如果返回的int值为-1，则表示流读取到了末尾
         */
        int d = 0;
        while ((d = isr.read()) != -1) {
            System.out.print((char) d);
        }

        isr.close();
    }
}
