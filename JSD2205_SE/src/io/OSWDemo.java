package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/*
java将流按照读写单位划分为：字节流、字符流
字节流：java.io.InputStream、java.io.OutputStream
字符流：java.io.Reader、java.io.Writer
Reader为所有字符输入流的超类，定义了所有字符输入流都必须具备的读取字符的方法
Writer为所有字符输出流的超类，定义了所有字符输出流都必须具备的写出字符的方法

字符流与字节流的区别:
读写单位不同，
字节流以一个字节（byte，8位2进制）为单位读写数据，
字符流则以一个字符（char）为单位读写数据，
所以字符流天生只适合读写【文本数据】。

转换流：java.io.InputStreamReader、java.io.OutputStreamWriter
转换流是一对字符流（分别继承自Reader和Writer），并且是一对高级流
转换流在实际开发中我们不会直接操作它们，但是在流连接中它们又是不可缺少的（在组件含有字符高级流的流连接中）
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向文件osw.txt中写入文本数据
        FileOutputStream fos = new FileOutputStream("./osw.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        /*
        Writer（字符输出流超类）上定义了所有字符输出流都必须具备的写出文本数据的相关方法：
        void write(String str)
         */
        String line = "eferwfwedqw";
        osw.write(line);
        osw.write("\r\n");
        osw.write("123423567658");
        System.out.println("写出完毕");

        osw.close();
    }
}
