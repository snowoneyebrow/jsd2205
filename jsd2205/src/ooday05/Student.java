package ooday05;

public class Student extends Person {
    String stuID;

    Student(String name, int age, String address, String stuID) {
        super(name, age, address);
        this.stuID = stuID;
    }

    @Override
    void sayHi() {
        System.out.println("我的名字是" + name + "，年龄是" + age + "，地址是" + address + "，学号是" + stuID);
    }
}