package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("./person.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person p = (Person) ois.readObject();
        //public final Object readObject()返回Object类型，所以要向下造型（强转）为Person类型
        System.out.println(p);

        ois.close();
    }
}
