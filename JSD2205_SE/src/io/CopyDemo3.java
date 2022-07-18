package io;

import java.io.*;

/**
 * 用不带缓存的输入输出流的话，不调用close方法也是可以复制成功的，只是删除不了源文件（文件被使用），用带缓存的输入输出流的话，如果没有自己调用flush清空缓存，最后一次读取的内容还会在缓存区中而没有输出，这时调用close会自动flush，清空缓存。
 * 调用 close() 关闭输入输出流，系统会强制清空缓冲区的数据，把数据写入文件或者读入程序，否则数据还会停留在缓冲区，调用flush() 也是可以的
 */
public class CopyDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./ppt.pptx");
        BufferedInputStream bis = new BufferedInputStream(fis, 1024 * 10); //指定缓冲区大小10k
        FileOutputStream fos = new FileOutputStream("./ppt_cp2.pptx");
        BufferedOutputStream bos = new BufferedOutputStream(fos, 1024 * 10);

        int d;
        long start = System.currentTimeMillis();
        while ((d = bis.read()) != -1) {
            bos.write(d);
        }
        bos.flush();
        //bos.close(); //close()自带flush()
        long end = System.currentTimeMillis();
        System.out.println("复制完毕，耗时" + (end - start) + "ms");

        bis.close();
        bos.close();
    }
}
