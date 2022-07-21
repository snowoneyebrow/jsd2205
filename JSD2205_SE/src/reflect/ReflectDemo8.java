package reflect;

import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;

//获取注解中的参数
public class ReflectDemo8 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class cls = Class.forName("reflect.Person");
        Method method = cls.getMethod("sayHello");
        if (method.isAnnotationPresent(AutoRunMethod.class)) {
            AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class); //获取该方法上的注解@AutoRunMethod
            int value = arm.value(); //通过注解对象获取value参数的值
            System.out.println(value);
        }
    }
}
