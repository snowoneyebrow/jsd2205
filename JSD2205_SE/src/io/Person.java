package io;

import java.io.Serializable;
import java.util.Arrays;

//使用此类测试对象流的对象读写操作
public class Person implements Serializable {
    public static final long serialVersionUID = 42L;

    private String name; //姓名
    private int age; //年龄
    private String gender; //性别
    /*
    transient关键字可以修饰一个属性，被修饰的属性在进行对象序列化时会被忽略。
    忽略不必要的属性可以达到对象序列化瘦身的目的。
     */
    private transient String[] otherInfo; //其他信息

    public Person(String name, int age, String gender, String[] otherInfo) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.otherInfo = otherInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String[] otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", otherInfo=" + Arrays.toString(otherInfo) +
                '}';
    }
}
