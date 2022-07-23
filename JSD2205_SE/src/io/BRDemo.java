package io;

import java.io.*;

/*
使用缓冲字符输入流读取文本数据

java.io.BufferedReader：
特点：
块读文本数据
可按行读取字符串
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
        //将当前源代码输出到控制台上
        FileInputStream fis = new FileInputStream("./src/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        /*
        BufferedReader提供了一个独有的方法：
        String readLine()：
        该方法会返回读取到的一行字符串，返回的字符串不含最后的换行符。
        如果单独读取了空行（这一行只有换行符），则返回值为空字符串。
        如果返回值为null，则表示流读取到了末尾。

        当第一次调用readLine()读取一行字符串时，
        实际上：缓冲流会一次性读取8192个字符（char）并存入到其内部字符数组中（块读操作），
        再将其中第一行字符串的内容返回。
        当我们第二次调用readLine()时，不会再次读取，而是直接将内部char数组中第二行字符串的内容返回。
         */
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
