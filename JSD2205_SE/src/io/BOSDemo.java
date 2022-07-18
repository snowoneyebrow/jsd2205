package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BOSDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        String line = "vwsdwqfn123";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);

        bos.write(data);
        bos.flush();
        System.out.println("写出完毕");
        bos.close();
    }
}
