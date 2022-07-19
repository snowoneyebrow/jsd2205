package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//使用指定的构造器实例化对象
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Person p = new Person("李四", 33);
        System.out.println(p);

        //1、加载类对象
        Class cls = Class.forName("reflect.Person");
        //2、通过类对象获取指定的有参构造器：Person(String,int)
        //Constructor c = cls.getConstructor(); //不传参获取的是无参构造器
        Constructor c = cls.getConstructor(String.class, int.class); //指定是哪个构造器
        Object obj = c.newInstance("王五", 66); //new Person("王五",66);
        System.out.println(obj);
    }
}
