package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

@AutoRunClass
public class Person {
    private String name = "张三";
    private int age = 22;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @AutoRunMethod(5)
    public void sayHello() {
        System.out.println(name + "：hello！");
    }

    public void sayHi() {
        System.out.println(name + "：hi！");
    }

    public void dance() {
        System.out.println(name + "：跳舞！");
    }

    public void sing() {
        System.out.println(name + "：唱歌！");
    }

    public void watchTV() {
        System.out.println(name + "：看电视！");
    }

    public void playGame() {
        System.out.println(name + "：玩游戏！");
    }

    public void say(String info) {
        System.out.println(name + "：说：" + info);
    }

    public void say(String info, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(name + "：说：" + info);
        }
    }

    private void hehe() {
        System.out.println("我是Person类的private方法！");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
