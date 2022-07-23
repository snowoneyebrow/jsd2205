package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
对象流：java.io.ObjectOutputStream、java.io.ObjectInputStream
对象流是一对高级流，可以方便我们读写任何java对象
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        //将一个Person对象写入文件person.obj
        String name = "苍老师";
        int age = 55;
        String gender = "男";
        String[] otherInfo = {"你们的技术启蒙老师", "拍片一流", "刘桑"};
        Person p = new Person(name, age, gender, otherInfo);

        FileOutputStream fos = new FileOutputStream("./person.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        /*
        当进行对象序列化时，可能出现异常：
        java.io.NotSerializableException
        这是由于写出的对象没有实现序列化接口导致的。

        对象序列化：将一个对象按照其结构转换为一组字节的过程
        数据持久化：将数据写到磁盘上做长久保存
         */
        oos.writeObject(p);
        System.out.println("写出完毕");

        oos.close();
    }
}
