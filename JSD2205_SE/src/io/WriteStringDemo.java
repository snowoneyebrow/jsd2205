package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//向文件中写入文本数据
public class WriteStringDemo {
    public static void main(String[] args) throws IOException {
        /*
        文件流常用的构造器：
        默认为覆盖模式：
        FileOutputStream(String path)
        FileOutputStream(File file)
        上述两种构造器创建文件流时，如果指定的文件已经存在了，则会将该文件原数据全部抹除。

        FileOutputStream(String path,boolean append)
        FileOutputStream(File file,boolean append)
        如果此时第二个参数为true，则文件流为追加模式，即：
        当指定的文件存在时，文件中原数据都保留，使用当前流写出的内容都会陆续追加到文件中去。
         */
        FileOutputStream fos = new FileOutputStream("fos.txt", true);

        String line = "edgver一二三四五gnnewfewsf";
        //getBytes：字符串转字节数组
        byte[] data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);

        line = "追加内容fewgh";
        data = line.getBytes(StandardCharsets.UTF_8);
        fos.write(data);

        System.out.println("写出完毕！");
        fos.close();
    }
}
