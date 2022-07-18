package file;

import java.io.File;

/**
 * make:做
 * directory:目录(windows下习惯叫作"文件夹")
 *
 * 创建一个空的目录
 */
public class MkDirDemo {
    public static void main(String[] args) {
        //在当前目录下新建一个目录demo
        //File dir = new File("./demo");
        //创建f目录，以下是f目录所在的结构：
        File dir = new File("./a/b/c/d/e/f");

        /*
            File常用方法:
            boolean mkdir()
            将当前File表示的目录在硬盘上实际创建出来。

            boolean mkdirs()
            将当前File表示的目录在硬盘上实际创建出来。

            mkdir和mkdirs最大的区别是:
            mkdir方法在创建目录时要求该目录所在的目录必须存在，否则会创建失败。
            而mkdirs则会将所有不存在的父目录一同创建出来。
            因此实际开发中绝大多数都是直接使用mkdirs这个方法创建目录。
         */
        if (dir.exists()) {
            System.out.println("该目录已存在!");
        } else {
            dir.mkdirs();
            System.out.println("该目录已创建!");
        }
    }
}
