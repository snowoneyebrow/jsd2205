package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Test3 {
    public static void main(String[] args) throws IOException {
        String address = "./src/io/";
        File dir = new File(address);
        if (dir.isDirectory()) {
            File[] subs = dir.listFiles(f -> f.getName().endsWith(".java")); //
            for (int i = 0; i < subs.length; i++) {
                File file = new File(address + subs[i].getName());
                FileInputStream fis = new FileInputStream(file);
                long len = file.length();
                System.out.println(address + file.getName());
                System.out.println("文件大小：" + len + "字节");
                byte[] data = new byte[(int) len];
                fis.read(data);
                String line = new String(data, StandardCharsets.UTF_8);
                System.out.println(line);
                fis.close();
            }
        }
    }
}
