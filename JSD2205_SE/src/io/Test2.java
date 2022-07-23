package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream("./note.txt", true);
        while (true) {
            System.out.println("请输入文字，输入exit退出：");
            String line = scan.nextLine();
            if ("exit".equalsIgnoreCase(line)) {
                //若line放equals前面，且line是null，则会抛出空指针异常，所以line放equals后面
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
