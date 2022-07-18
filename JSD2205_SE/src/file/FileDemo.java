package file;

import java.io.File;

/**
 * io:input output
 *     输入   输出
 *
 * java.io.File：
 * File的每一个实例用于表示硬盘上的一个文件或目录。实际上表示的是一个抽象路径。
 *
 * File可以:
 * 1:访问其表示的文件或目录的属性信息(名字，大小，修改时间等)
 * 2:操作(创建，删除)文件或目录
 * 3:访问一个目录中的所有子项
 *
 * 但是File不能访问文件数据！
 */
public class FileDemo {
    public static void main(String[] args) {
        /*
            创建File时常用的构造方法:File(String path)
            path指定该文件的路径。
            路径推荐用相对路径，有更好的跨平台性。
            其中常用的是:"./"即当前目录。
            在idea执行当前程序时，"./"表示的位置就是当前程序所在的项目目录:如JSD2205_SE这个目录
         */
        File file = new File("./demo.txt");

        /*
            File提供了一组方法可以获取其表示的文件或目录的属性信息
            String getName()
            返回当前文件或目录的名字

            long length()
            返回当前文件的大小，单位是字节。

            boolean canRead()
            返回一个boolean表达该文件是否可读

            boolean canWrite()
            返回一个boolean表达该文件是否可写
         */
        String name = file.getName();
        System.out.println("名字:" + name);

        long length = file.length(); //注意：是long类型！
        System.out.println(length + "字节"); //文件不存在返回0字节

        boolean cr = file.canRead();
        System.out.println("是否可读:" + cr);

        boolean cw = file.canWrite();
        System.out.println("是否可写:" + cw);
    }
}
