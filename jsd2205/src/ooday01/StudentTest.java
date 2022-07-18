package ooday01;

//学生类的测试类
public class StudentTest {
    public static void main(String[] args) {
        //创建一个学生对象
        Student zs = new Student();

        //给成员变量赋值
        zs.name = "zhangsan";
        zs.age = 25;
        zs.address = "河北廊坊";

        //调用方法
        zs.study();
        zs.sayHi();

        Student ww = new Student();
        //1)创建了一个学生对象
        //2)给所有成员变量赋默认值
        ww.study(); //null
        ww.sayHi(); //null 0 null
    }
}