package com.webserver.core;

import com.webserver.annotations.Controller;
import com.webserver.annotations.RequestMapping;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
    private static Map<String, Method> mapping = new HashMap<>();

    static {
        init();
    }

    private static void init() {
        try {
            //有getClassLoader()就是上一层，没有就是当前层
            //"."表示target/classes
            File dir = new File(HandlerMapping.class.getClassLoader().getResource("./com/webserver/controller").toURI());
            File[] subs = dir.listFiles(f -> f.getName().endsWith(".class"));
            String packageName = "com.webserver.controller";
            for (File sub : subs) {
                Class cls = Class.forName(packageName + "." + sub.getName().split("\\.")[0]);
                if (cls.isAnnotationPresent(Controller.class)) {
                    Method[] methods = cls.getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            RequestMapping rm = method.getAnnotation(RequestMapping.class);
                            mapping.put(rm.value(), method);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Method getMethod(String path) {
        return mapping.get(path);
    }

    /*public static void main(String[] args) {
        Method method = getMethod("/userList");
        System.out.println(method.getDeclaringClass().getName());
        System.out.println(method.getName());
    }*/
}
