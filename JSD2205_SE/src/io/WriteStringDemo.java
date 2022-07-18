package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("fos.txt", true);
        //无true是覆盖，有true是追加（第二个文件流时追加，不是当前流里追加）

        String line = "edgver一二三四五gnnewfewsf";
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);

        line = "追加内容fewgh";
        data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);

        System.out.println("写出完毕");
        fos.close();
    }
}
