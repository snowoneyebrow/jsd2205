package homework.day02;

import java.io.*;

/**
 * 将当前目录下的所有文件都复制一份，复制的文件命名为:原
 * 文件名_cp.后缀
 * 比如原文件为:test.dat
 * 复制后的文件为:test_cp.dat
 * <p>
 * 思路:
 * 分为几部分考虑.
 * 第一个是要获取到当前目录中的所有文件(思考哪个API可以解决)
 * 第二个是获取到的每一个文件都要复制(复制用什么API)
 * 第三个是复制的文件名，如何重新组建xxx_cp.xxx的名字?
 * 这里要将原文件名拆开后想办法拼接_cp.
 *
 * @author Xiloer
 */

public class Test03 {
    public static void main(String[] args) throws IOException {
        String address = "./src/io/";
        File dir = new File(address);
        if (dir.isDirectory()) {
            File[] subs = dir.listFiles(f->f.isFile()); //
            for (int i = 0; i < subs.length; i++) {
                String n = subs[i].getName();
                String name = address + n;
                int point = n.lastIndexOf(".");
                String addressCopy = address + "temp/";
                new File(addressCopy).mkdir();
                String nameCopy = addressCopy + n.substring(0, point) + "_cp" + n.substring(point);

                FileInputStream fis = new FileInputStream(name);
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream(nameCopy);
                BufferedOutputStream bos = new BufferedOutputStream(fos);

                int d;
                while ((d = bis.read()) != -1) {
                    bos.write(d);
                }
                bos.flush();

                fis.close();
                fos.close();
            }
        }
    }
}
