package file;

import java.io.File;
import java.io.IOException;

/**
 * create:创建
 * new:新的
 * file:文件
 * exists:存在
 * 使用File新建一个空文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //在当前目录下新建一个文件:test.txt
        File file = new File("./test.txt");

        /*
            File的方法:
            boolean exists()
            返回当前File对象表示的文件或目录是否真实存在，true:存在，false:不存在

            boolean createNewFile()
            将当前File对象表示的文件在硬盘该位置上实际创建出来
         */
        if (file.exists()) {
            System.out.println("该文件已存在!");
        } else {
            file.createNewFile();
            System.out.println("该文件已创建!");
        }
    }
}
