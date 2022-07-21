package homework.day02;

import java.io.File;
import java.util.Scanner;

//程序启动后要求用户输入一个关键字，然后列出当前项目下所有名字中包含该关键字的子项
public class Test01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入关键字：");
        String key = s.nextLine();
        File dir = new File("./src/io/"); //定位当前目录
        if (dir.isDirectory()) { //判断是否为目录
            File files[] = dir.listFiles(); //获取该目录下所有子项
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName(); //获取每一个子项的名字
                if (fileName.contains(key)) { //判断名字中是否包含key的内容
                    System.out.println(fileName); //包含就输出这个名字
                }
            }
        }
    }
}
