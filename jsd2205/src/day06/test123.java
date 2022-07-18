package day06;

import java.util.Arrays;

public class test123 {
    public static void main(String[] args) {

    }

    //无参，无返回值
    public static void say() {
        System.out.println("大家好，我叫WKJ，今年38岁了");
    }

    //有参，无返回值
    public static void sayHi(String name) { //形参
        System.out.println("大家好，我叫" + name + "，今年38岁了");
    }

    //有参，无返回值
    public static void sayHello(String name, int age) { //形参
        System.out.println("大家好，我叫" + name + "，今年" + age + "岁了");
    }

    //无参，有返回值
    public static double getNum() {
        //有返回值的方法中，必须有return
        //并且return后数据的类型还必须与返回值类型匹配
        //return "abc"; //编译错误，返回值类型不匹配
        return 8.88; //1)结束方法的执行  2)返回结果给调用方
    }

    //有参，有返回值
    public static int plus(int num1, int num2) {
        int num = num1 + num2;
        return num; //返回的是num里面的那个数
        //return num1+num2; //返回的是num1与num2的和
        //建议这样写：return num1+num2;
    }

    //无参，有返回值
    public static int[] testArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }
}