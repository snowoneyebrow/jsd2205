package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 自动调用Person类中所有无参方法：
 * <p>
 * Method的方法：
 * int getParameterCount()：
 * 返回当前Method表示的方法的参数个数
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            //判断是否为无参且public的方法
            if (method.getParameterCount() == 0 && method.getModifiers() == Modifier.PUBLIC && method.getName().contains("a")) {
                method.invoke(obj);
            }
        }
    }
}
