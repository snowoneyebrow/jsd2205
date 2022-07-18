package homework.day01;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个文件名：");
            String name = scan.nextLine();
            File file = new File("./" + name);
            if (file.exists()) {
                System.out.println("该文件名已存在，请更换");
            } else {
                file.createNewFile();
                System.out.println(file.getName() + "创建成功");
                break;
            }
        }
    }
}
