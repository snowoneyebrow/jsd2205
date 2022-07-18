package com.webserver.test;

//单例模式
//全局最多一个实例
//不让外面的人new
public class Singleton {
    //这是饿汉式（还有一个懒汉式）
    private static Singleton singleton;

    static { //先调static块（，再调构造方法）
        singleton = new Singleton();
    }

    public static Singleton getSingleton() { //static保证不能通过对象.方法，只能类名.方法
        return singleton;
    }
}
