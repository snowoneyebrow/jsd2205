package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//缓冲输出流写出时的缓冲区问题
public class BOSDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("./bos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        String line = "vwsdwqfn123";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);

        /*
        flush()方法实际上是在接口Flushable上定义的抽象方法，
        而字节输出流超类java.io.OutputStream实现了该接口，
        这意味着所有字节输出流都具有该方法：flush()。
        但不是所有的高级流的flush()方法都是做写出缓冲操作的，
        而是将flush()方法一级级传递下去，
        最终传递到缓冲输出流上完成真实的flush()方法操作。
         */
        bos.write(data);
        bos.flush();
        System.out.println("写出完毕");

        bos.close();
    }
}
