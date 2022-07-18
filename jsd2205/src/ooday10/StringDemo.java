package ooday10;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "123abc"; //堆中创建一个123abc对象，常量池中存储这个对象的引用
        //编译器在编译时，若发现是两个字面量连接，则直接运算好并将结果保存起来，
        //如下代码相当于 String s2 = "123abc";
        String s2 = "123" + "abc"; //复用常量池中的123abc对象
        System.out.println(s1 == s2); //true

        //如下代码会在堆中创建新的123abc对象，而不会重用常量池中的对象
        String s3 = "123";
        String s4 = s3 + "abc";
        System.out.println(s1 == s4); //false
    }
}