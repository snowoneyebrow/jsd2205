package ooday04;

public class Test {
    public static void main(String[] args) {
        Person[] ps = new Person[5];
        ps[0] = new Student("zhangsan", 25, "LF", "111");
        ps[1] = new Student("lisi", 24, "JMS", "222");
        ps[2] = new Teacher("wangwu", 34, "SD", 8000.0);
        ps[3] = new Teacher("zhaoliu", 28, "SX", 9000.0);
        ps[4] = new Doctor("sunqi", 56, "HEB", "主任医师");
        for (int i = 0; i < ps.length; i++) {
            System.out.println(ps[i].name);
            ps[i].sayHi();
        }

        Student zs = new Student("zhangsan", 25, "LF", "111");
        zs.sayHi();
        Person p = new Student("zhangsan", 25, "LF", "111");
        p.sayHi();
    }
}