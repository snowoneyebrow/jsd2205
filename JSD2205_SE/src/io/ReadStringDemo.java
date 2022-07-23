package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//使用文件流从文件中读取文本数据
public class ReadStringDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("./src/io/ReadStringDemo.java");
        FileInputStream fis = new FileInputStream(file);

        long len = file.length(); //注意返回值为long！
        System.out.println("文件大小：" + len + "字节");

        //整个文件一次性读取，并存到字节数组中
        byte[] data = new byte[(int) len];
        fis.read(data);

        //字节数组转字符串
        String line = new String(data, StandardCharsets.UTF_8);
        System.out.println(line);

        fis.close();
    }
}
