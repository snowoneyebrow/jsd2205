package reflect;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;

//自动调用与当前类Test2在同一个包中所有类中的无参且public的方法
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException, InvocationTargetException {
        File dir = new File(Test2.class.getResource(".").toURI());
        File[] subs = dir.listFiles(f -> f.getName().endsWith(".class"));
        String packageName = Test2.class.getPackage().getName();
        for (File sub : subs) {
            Class cls = Class.forName(packageName + "." + sub.getName().split("\\.")[0]);
            Object obj = cls.newInstance();
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getParameterCount() == 0 && method.getModifiers() == Modifier.PUBLIC) {
                    method.invoke(obj);
                }
            }
        }
    }
}
