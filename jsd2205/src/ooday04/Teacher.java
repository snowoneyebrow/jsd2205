package ooday04;

public class Teacher extends Person {
    double salary;

    Teacher(String name, int age, String address, double salary) {
        super(name, age, address);
        this.salary = salary;
    }

    void sayHi() {
        System.out.println("我的名字是" + name + "，年龄是" + age + "，地址是" + address + "，工资是" + salary);
    }
}