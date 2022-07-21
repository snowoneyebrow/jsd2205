package homework.day02;

import java.io.*;

//将当前目录下的所有文件都复制一份，复制的文件命名为：原文件名_cp.后缀
public class Test03 {
    public static void main(String[] args) throws IOException {
        String address = "./src/io/";
        File dir = new File(address);
        if (dir.isDirectory()) {
            File[] subs = dir.listFiles(f -> f.isFile());
            for (int i = 0; i < subs.length; i++) {
                String name = subs[i].getName();
                int index = name.lastIndexOf(".");
                String addressCopy = address + "temp/";
                new File(addressCopy).mkdir();
                String nameCopy = addressCopy + name.substring(0, index) + "_cp" + name.substring(index);

                FileInputStream fis = new FileInputStream(address + name);
                FileOutputStream fos = new FileOutputStream(nameCopy);

                int d;
                byte[] data = new byte[1024 * 10]; //10kb
                while ((d = fis.read(data)) != -1) {
                    //一次性至少读data数组长度的字节进来（10k），返回值（d）为实际读了多少个字节
                    fos.write(data, 0, d);
                }

                fis.close();
                fos.close();
            }
        }
    }
}
