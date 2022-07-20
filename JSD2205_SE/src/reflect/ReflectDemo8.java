package reflect;

import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;

public class ReflectDemo8 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class cls = Class.forName("reflect.Person");
        Method method = cls.getMethod("sayHello");
        if (method.isAnnotationPresent(AutoRunMethod.class)) {
            AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
            int value = arm.value();
            System.out.println(value);
        }
    }
}
