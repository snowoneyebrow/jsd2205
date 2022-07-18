package ooday05;

public class Person {
    String name;
    int age;
    String address;

    Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    void sayHi() {
        System.out.println("我的名字是" + name + "，年龄是" + age + "，地址是" + address);
    }
}