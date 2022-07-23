package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//使用对象输入流进行反序列化
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);

        /*
        反序列化对象：
        该方法可能会抛出异常：java.io.InvalidClassException
        原因：对象输入流在反序列化对象时，发现该对象的序列化版本号与当前类定义的版本号不一致。
        一个类实现了序列化接口后，会有一个序列化版本号，
        只要类的结构没有发生过改变，那么该版本号的值是不会发生变化的，
        一旦类的结构发生了改变，那么版本号就会发生改变。
         */
        Person p = (Person) ois.readObject();
        //public final Object readObject()方法返回Object类型，所以要向下造型（强转）为Person类型
        System.out.println(p);
        System.out.println(p.getName());

        ois.close();
    }
}
