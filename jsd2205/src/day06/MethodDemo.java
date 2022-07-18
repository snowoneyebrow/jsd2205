package day06;

public class MethodDemo {
    public static void main(String[] args) {
        double a = getNum(); //getNum()的值就是return后的那个数
        System.out.println(a); //8.88，模拟对返回值的后续操作

        int b = plus(5, 6); //plus(5,6)的值就是return后的那个数
        System.out.println(b); //11，模拟对返回值的后续操作

        int m = 5, n = 6;
        int c = plus(m, n); //传递的是m和n里面的数
        System.out.println(c); //11，模拟对返回值的后续操作

        int[] d = testArray();
        System.out.println(d.length); //10，模拟对返回值的后续操作


        say(); //调用say()方法

        //sayHi(); //编译错误，有参必须传参
        //sayHi(250); //编译错误，参数类型必须匹配
        sayHi("张三"); //String name="张三" //实参
        sayHi("李四"); //String name="李四" //实参
        sayHi("王五"); //String name="王五" //实参

        sayHello("张三", 25); //实参 String name = "张三"; int age = 25;
        sayHello("李四", 24); //实参


        say();
        sayHi("java");
        sayHello("c++", 99);
        System.out.println();

        a();
        System.out.println(444);
    }

    public static void a() {
        System.out.println(111);
        b();
        System.out.println(222);
    }

    public static void b() {
        System.out.println(333);
    }

    public static void say() {
        System.out.println("大家好");
    }

    public static void sayHi(String name) {
        System.out.println("大家好，我叫" + name);
    }

    public static void sayHello(String name, int age) {
        System.out.println("大家好，我叫" + name + "，今年" + age + "岁了");
    }

    public static double getNum() {
        return 1.23;
    }

    public static int plus(int num1, int num2) {
        return num1 + num2;
    }

    public static int[] testArray() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        return a;
    }
}
