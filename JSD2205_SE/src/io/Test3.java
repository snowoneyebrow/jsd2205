package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//将io包下的每一个java文件的内容输出到控制台上
public class Test3 {
    public static void main(String[] args) throws IOException {
        String address = "./src/io/";
        File dir = new File(address);

        if (dir.isDirectory()) {
            //获取该目录下的所有java文件
            File[] subs = dir.listFiles(f -> f.getName().endsWith(".java"));

            for (int i = 0; i < subs.length; i++) {
                File file = new File(address + subs[i].getName());
                System.out.println(file.getName());

                FileInputStream fis = new FileInputStream(file);

                long len = file.length(); //获取文件的大小（字节量）
                System.out.println("文件大小：" + len + "字节");

                byte[] data = new byte[(int) len]; //根据文件大小创建等长的字节数组
                fis.read(data); //块读取，一次性将文件所有数据读取到字节数组中

                //利用String的构造器，将字节数组所有内容按照指定的UTF-8字符集还原为字符串
                String line = new String(data, StandardCharsets.UTF_8);
                System.out.println(line);

                fis.close();
            }
        }
    }
}
