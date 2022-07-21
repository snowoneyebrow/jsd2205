package homework.day03;

import java.io.*;
import java.util.Scanner;

//设计一个类：User，当前程序启动后要求用户顺序输入User的四个信息
//然后实例化一个User对象保存这四个信息并将该对象序列化到文件中
//文件名的命名规则：用户名.obj
public class Test02 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String pwd = scanner.nextLine();
        System.out.println("请输入昵称：");
        String nick = scanner.nextLine();
        System.out.println("请输入年龄：");
        int age = scanner.nextInt();

        User user = new User(name, pwd, nick, age);

        try (
                FileOutputStream fos = new FileOutputStream("./" + name + ".obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(user);
            System.out.println("写出完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
