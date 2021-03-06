package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;

//输出与当前类Test3在同包中被@AutoRunClass标注过的类的类名
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException, InvocationTargetException {
        File dir = new File(Test3.class.getResource(".").toURI());
        File[] subs = dir.listFiles(f -> f.getName().endsWith(".class"));
        String packageName = Test3.class.getPackage().getName();
        for (File sub : subs) {
            Class cls = Class.forName(packageName + "." + sub.getName().split("\\.")[0]);
            if (cls.isAnnotationPresent(AutoRunClass.class)) {
                System.out.println(cls.getName() + "被@AutoRunClass标注了");
                Object obj = cls.newInstance(); //类对象的实例对象的实例化
                Method[] methods = cls.getDeclaredMethods(); //输出该类中所有被@AutoRunMethod标注的方法
                for (Method method : methods) {
                    if (method.isAnnotationPresent(AutoRunMethod.class)) {
                        System.out.println(cls.getName() + "." + method.getName() + "()被@AutoRunMethod标注了");
                        AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
                        int value = arm.value();
                        for (int i = 0; i < value; i++) {
                            method.invoke(obj);
                        }
                    }
                }
            }
        }
    }
}
