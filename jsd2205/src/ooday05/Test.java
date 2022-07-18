package ooday05;

public class Test {
    public static void main(String[] args) {
        Person[] ps = new Person[5];
        ps[0] = new Student("张三", 21, "广州", "20220101");
        ps[1] = new Student("李四", 22, "深圳", "20220102");
        ps[2] = new Teacher("王五", 23, "佛山", 5000.0);
        ps[3] = new Teacher("赵六", 24, "东莞", 6000.0);
        ps[4] = new Doctor("孙七", 25, "中山", "正高");

        for (int i = 0; i < ps.length; i++) {
            Person p = ps[i];
            System.out.println(p.name);
            p.sayHi();
        }
    }
}

/*
作业
写在ooday05包中
如下的类必须分在不同的文件中写
1.创建Person类，包含:
  1)成员变量:name,age,address
  2)构造方法:Person(3个参数){ 赋值 }
  3)方法:sayHi(){ 输出3个数据 }
2.创建学生类Student，继承Person，包含:
  1)成员变量:学号stuId(String)
  2)构造方法:Student(4个参数){ super调超类3参构造、赋值stuId }
  3)方法:重写sayHi(){ 输出4个数据 }
3.创建老师类Teacher，继承Person，包含:
  1)成员变量:工资salary(double)
  2)构造方法:Teacher(4个参数){ super调超类3参构造、赋值salary }
  3)方法:重写sayHi(){ 输出4个数据 }
4.创建医生类Doctor，继承Person，包含:
  1)成员变量:职称level(String)
  2)构造方法:Doctor(4个参数){ super调超类3参构造、赋值level }
5.创建测试类Test，main中:
  1)创建Person数组ps,包含5个元素,给元素赋值(学生/老师/医生),遍历输出名字并问好
 */