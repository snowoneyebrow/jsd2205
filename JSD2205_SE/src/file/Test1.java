package file;

import java.io.File;
import java.io.IOException;

/**
 * 在当前目录下创建100个文件，名字为test1.txt - test100.txt
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 100; i++) {
            File file = new File("./test" + i + ".txt");
            if (!file.exists()) {
                file.createNewFile();
                System.out.println(file.getName() + " 创建成功");
            } else {
                System.out.println(file.getName() + " 已存在");
            }
        }
        System.out.println("创建完毕!");
    }
}
