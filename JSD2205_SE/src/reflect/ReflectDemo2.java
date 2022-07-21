package reflect;

import java.util.ArrayList;
import java.util.Scanner;

//使用反射机制实例化对象
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        //Class cls = Class.forName("java.util.ArrayList");

        //1、获取要实例化对象的类的类对象
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        /*
        java.util.HashMap
        java.util.Date
        reflect.Person
         */
        String className = scanner.nextLine();
        Class cls = Class.forName(className);

        //2、调用Class的newInstance()方法来调用无参构造器
        Object obj = cls.newInstance();
        System.out.println(obj);
    }
}
