package reflect;

import reflect.annotations.AutoRunClass;

public class ReflectDemo7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = Class.forName("reflect.Person");
        boolean flag = cls.isAnnotationPresent(AutoRunClass.class);
        System.out.println(flag);
    }
}
