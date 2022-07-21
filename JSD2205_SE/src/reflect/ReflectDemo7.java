package reflect;

import reflect.annotations.AutoRunClass;

//反射机制访问注解
public class ReflectDemo7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = Class.forName("reflect.Person");
        /*
            Class、Method等常用的反射对象都提供了一个方法：
            boolean isAnnotationPresent(Class cls)：
            用于判断是否被参数指定的注解标注过（参数为注解的类对象）
         */
        boolean flag = cls.isAnnotationPresent(AutoRunClass.class);
        System.out.println(flag);
    }
}
