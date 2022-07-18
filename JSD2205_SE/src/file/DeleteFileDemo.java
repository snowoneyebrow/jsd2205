package file;

import java.io.File;

/**
 * delete:删除
 * 删除一个文件
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        //将当前目录下的test.txt文件删除
        //相对路径中最开始的"./"可以忽略不写，默认就是从"./"开始的
        File file = new File("./test.txt");
        if (file.exists()) {
            file.delete(); //彻底删除，不放回收站
            System.out.println("该文件已删除!");
        } else {
            System.out.println("该文件不存在!");
        }

        //删除当前目录中的test1.txt - test100.txt
        for (int i = 1; i <= 100; i++) {
            File f = new File("./test" + i + ".txt");
            if (f.exists()) {
                f.delete();
                System.out.println("该文件已删除!");
            } else {
                System.out.println("该文件不存在!");
            }
        }
        System.out.println("删除完毕!");
    }
}
