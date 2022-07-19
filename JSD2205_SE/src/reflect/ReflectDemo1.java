package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * java反射机制：
 * 反射机制是java的动态机制，可以在程序“运行期间”再确定实例化对象、方法调用、属性操作等。
 * 反射机制可以提高代码的灵活度，但是会带来较多的系统开销和较低的运行效率，因此不能过度依赖。
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
            Class类：Class类称为类的类对象。
            JVM加载一个类的class文件时，就会创建一个Class实例与该类绑定。
            因此每个被加载的类都有且只有一个Class实例，这个实例就是加载的该类的类对象。
            通过一个类的类对象我们可以获取这个类的一切信息（类名、属性、方法、构造器等），从而在程序运行期间进行相关的操作。

            因此反射第一步就是要获取操作的类的类对象。获取方式有三种：
            1、类名.class：
            Class cls = String.class;

            2、Class.forName(String className)：
            Class cls = Class.forName("java.lang.String"); //参数需要是完全限定名：包名.类名
            注意：基本类型不支持此种方式获取类对象！

            3、ClassLoader类加载器形式获取：......
         */

        //获取String的类对象
        //Class cls = String.class;

        //Class cls = Class.forName("java.lang.String");

        /*
        可用例子：
        java.util.ArrayList
        java.util.HashMap
        java.io.FileInputStream
        java.lang.String
        reflect.Person
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要加载的类的名字：");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);

        String name = cls.getName(); //获取完全限定名：包名.类名
        System.out.println(name);

        name = cls.getSimpleName(); //仅获取类名
        System.out.println(name);

        String packageName = cls.getPackage().getName(); //获取包名
        System.out.println(packageName);

        //获取String类的所有public方法（包含从超类（Object）继承的方法）
        //Method[] methods = cls.getMethods();

        //获取本类自己定义的方法（包含private方法）
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
