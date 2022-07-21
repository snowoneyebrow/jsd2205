package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

//利用反射机制调用方法
public class ReflectDemo4 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Person p = new Person();
        p.watchTV();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名："); //reflect.Person
        String className = scanner.nextLine();
        System.out.println("请输入方法名："); //watchTV
        String methodName = scanner.nextLine();

        //1、实例化
        //1.1、加载类对象
        Class cls = Class.forName(className);
        //1.2、实例化
        Object obj = cls.newInstance();

        //2、调用方法
        //2.1、通过类对象获取要调用的方法
        Method method = cls.getMethod(methodName);
        //2.2、通过方法对象执行该方法
        method.invoke(obj); //obj.watchTV()，前提是obj表示的是一个Person对象
    }
}
