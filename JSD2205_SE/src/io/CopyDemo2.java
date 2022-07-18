package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./sea.png");
        FileOutputStream fos = new FileOutputStream("./copy.png");

        int d;
        byte[] data = new byte[1024 * 10]; //10kb
        long start = System.currentTimeMillis();
        while ((d = fis.read(data)) != -1) {
            fos.write(data, 0, d);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕，耗时" + (end - start) + "ms");

        fos.close();
        fis.close();
    }
}
