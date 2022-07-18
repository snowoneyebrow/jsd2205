package ooday03;

public class RefArrayDemo {
    public static void main(String[] args) {
        //注意：对于引用数组，必须给所有元素赋值，否则访问时会发生NullPointerException空指针异常
        Student[] stus = new Student[3]; //创建Student数组对象
        stus[0] = new Student("zhangsan", 25, "LF"); //创建Student对象
        stus[1] = new Student("lisi", 24, "JMS");
        stus[2] = new Student("wangwu", 26, "SD");
        System.out.println(stus[0].name); //输出第1个学生的名字
        stus[1].age = 28; //修改第2个学生的年龄为28
        stus[2].sayHi(); //第3个学生跟大家问好

        for (int i = 0; i < stus.length; i++) { //遍历学生数组
            System.out.println(stus[i].name); //输出每个学生的名字
            stus[i].sayHi(); //每个学生跟大家问好
        }
    }
}