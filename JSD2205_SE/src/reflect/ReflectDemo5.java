package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//调用有参方法
public class ReflectDemo5 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

        Method method = cls.getMethod("say", String.class);
        method.invoke(obj, "你好！");

        Method method2 = cls.getMethod("say", String.class, int.class);
        method2.invoke(obj, "嘿嘿", 3);
    }
}
