package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo6 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //Person p = new Person();
        //p.hehe(); //编译不通过！hehe是私有方法！

        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

        //Class的方法：getMethod()、getMethods()都只能获取到类对象表示的类的public方法
        //Method method = cls.getMethod("hehe");
        Method method = cls.getDeclaredMethod("hehe"); //获取本类自己定义的方法（包含private方法）
        method.setAccessible(true); //强行打开访问权限，使private可以被外部访问，不过慎用！
        method.invoke(obj);
        method.setAccessible(false); //用完就关！
    }
}
