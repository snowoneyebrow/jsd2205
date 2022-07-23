package io;

import java.io.*;

/*
缓冲流：
java.io.BufferedInputStream：缓冲字节输入流
java.io.BufferedOutputStream：缓冲字节输出流
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        缓冲流是一对高级流，在流连接中的作用是提高读写效率，具体是将读写操作统一转换为块读写来保证效率的。
        缓冲流默认的缓冲区大小为8kb（内部维护了一个字节数组），其提供的重载构造器可以修改缓冲区大小。
         */
        FileInputStream fis = new FileInputStream("./ppt.pptx");
        BufferedInputStream bis = new BufferedInputStream(fis, 1024 * 10); //指定缓冲区大小为10k
        FileOutputStream fos = new FileOutputStream("./ppt_copy.pptx");
        BufferedOutputStream bos = new BufferedOutputStream(fos, 1024 * 10);

        int d = 0;
        long start = System.currentTimeMillis();
        while ((d = bis.read()) != -1) {
            bos.write(d);
        }
        bos.flush();
        //bos.close(); //close()自带flush()
        long end = System.currentTimeMillis();
        System.out.println("复制完毕！耗时" + (end - start) + "ms");

        bis.close();
        bos.close();
        /*
        用不带缓存的输入输出流的话，不调用close()方法也可以复制成功，只是这时删除不了源文件（文件被使用）。
        用带缓存的输入输出流的话，如果自己没有调用flush()方法清空缓存，
        那么最后一次读取的内容还会留在缓冲区中，没有输出，
        如果这时调用close()方法关闭输入输出流，那么会自动调用flush()方法，
        强制清空缓冲区的数据，把数据写入文件或者读入程序。
         */
    }
}
