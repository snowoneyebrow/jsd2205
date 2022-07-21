package homework.day01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//程序启动后，要求用户输入一个文件名，如果文件存在则提示并要求用户更换，
//直到该文件还不存在为止，然后将这个文件在当前目录中创建出来。
public class Test01 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个文件名：");
            String name = scan.nextLine();
            File file = new File("./" + name);
            if (file.exists()) {
                System.out.println("该文件名已存在，请更换！");
            } else {
                file.createNewFile();
                System.out.println(file.getName() + "创建成功！");
                break;
            }
        }
    }
}
