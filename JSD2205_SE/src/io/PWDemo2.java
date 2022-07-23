package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//在流连接中使用PrintWriter
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        //向pw2.txt文件中写入字符串
        FileOutputStream fos = new FileOutputStream("./pw2.txt", true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw, true);
        /*
        PrintWriter提供了可以打开自动行刷新功能的构造器，
        当第一个参数为一个流时，就支持再传入一个boolean值，
        如果该值为true，则打开了自动行刷新，
        此时每当我们调用一次println()方法，就会自动调用flush()方法。
        只有println()方法才能自动行刷新，print()方法不行。
         */

        /*
        完成记事本功能：
        程序启动后，将用户在控制台输入的每一行字符串都按行写入文件中。
        当用户单独输入“exit”时，程序退出。
         */
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入文字，输入exit退出：");
            String line = scan.nextLine();
            if ("exit".equals(line)) {
                System.out.println("程序退出");
                break;
            }
            pw.println(line);
            System.out.println("保存成功");
        }

        pw.close();
    }
}
