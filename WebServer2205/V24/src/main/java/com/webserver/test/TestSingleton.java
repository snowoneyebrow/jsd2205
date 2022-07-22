package com.webserver.test;

public class TestSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleton();
        System.out.println(singleton);

        Singleton singleton1 = Singleton.getSingleton();
        System.out.println(singleton1);
    }
}
