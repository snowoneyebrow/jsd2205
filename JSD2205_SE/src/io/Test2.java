package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
完成一个简易记事本工具：
程序启动后，将用户在控制台上输入的每一行字符串都写入到文件note.txt中。
当用户单独输入“exit”时程序退出。
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("./note.txt");
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入文字，输入exit退出：");
            String line = scan.nextLine();
            if ("exit".equalsIgnoreCase(line)) {
                //若line放equals前面，当line是null时，会抛出空指针异常，所以line应该放equals后面
                //equalsIgnoreCase：忽略大小写的比较
                System.out.println("程序退出");
                break;
            }
            line += "\r\n"; //换行
            byte[] data = line.getBytes(StandardCharsets.UTF_8);
            fos.write(data);
            System.out.println("写入成功");
        }
        fos.close();
    }
}
