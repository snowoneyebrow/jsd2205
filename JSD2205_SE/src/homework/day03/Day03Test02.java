package homework.day03;

import java.io.*;
import java.util.Scanner;

/**
 * 设计一个类:User
 * <p>
 * 里面有四个属性:String name,String pwd,String nick,int age
 * <p>
 * 定义get,set方法以及toString方法和构造方法
 * <p>
 * 单词记一记:
 * <p>
 * pwd   是单词password的缩写，是密码的意思
 * <p>
 * user  用户
 * <p>
 * 当前程序启动后要求用户顺序输入以上四个信息
 * <p>
 * 然后实例化一个User对象保存着四个信息并将该对象序列化到文件中。
 * <p>
 * 文件名的命名规则:用户名.obj
 * <p>
 * 比如该用户输入用户名为张三，那么这个对象序列化后的文件名为:张三.obj
 *
 * @author Xiloer
 */

public class Day03Test02 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String name = scan.nextLine();
        System.out.println("请输入密码：");
        String pwd = scan.nextLine();
        System.out.println("请输入昵称：");
        String nick = scan.nextLine();
        System.out.println("请输入年龄：");
        int age = scan.nextInt();

        User user = new User(name, pwd, nick, age);

        FileOutputStream fos = new FileOutputStream("./" + name + ".obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(user);
        oos.flush();
        System.out.println("写出完毕");

        fos.close();
    }
}
