package homework.day03;

import java.io.*;

//使用缓冲流完成文件的复制操作
public class Test01 {
    public static void main(String[] args) throws IOException {
        /*
        try后面加括号，自动关闭流：

        原写法：
        try {
            FileInputStream fis = new FileInputStream(file);
            int a = 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        java7后的新写法：
        try (
                FileInputStream fis = new FileInputStream(file);
        ) {
            int a = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
         */

        try (
                FileInputStream fis = new FileInputStream("test.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                FileOutputStream fos = new FileOutputStream("test_cp.txt");
                BufferedOutputStream bos = new BufferedOutputStream(fos);
        ) {
            int d;
            while ((d = bis.read()) != -1) {
                bos.write(d);
            }
            System.out.println("复制完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
