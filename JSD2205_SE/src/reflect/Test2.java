package reflect;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;

//自动调用与当前类Test2在同一个包中所有类中的无参且public的方法
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException, InvocationTargetException {
        File dir = new File(Test2.class.getResource(".").toURI()); //定位当前类所在的包（目录）
        File[] subs = dir.listFiles(f -> f.getName().endsWith(".class"));
        String packageName = Test2.class.getPackage().getName();
        for (File sub : subs) {
            //通过每一个class文件的文件名得到类名
            //根据Test2这个类的包名来拼接其它同包类的完全限定名
            //加载该类的类对象
            Class cls = Class.forName(packageName + "." + sub.getName().split("\\.")[0]); //substring(0,fileName.indexOf("."))
            Object obj = cls.newInstance(); //实例化对象
            Method[] methods = cls.getDeclaredMethods(); //根据类对象获取该类中所有定义的方法
            for (Method method : methods) {
                if (method.getParameterCount() == 0 && method.getModifiers() == Modifier.PUBLIC) {
                    method.invoke(obj);
                }
            }
        }
    }
}
