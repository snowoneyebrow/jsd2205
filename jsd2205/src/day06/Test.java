package day06;

public class Test {
    public static void main(String[] args) {
        say();

        sayHi("java");

        sayHello("java", 99);

        double a = getNum();
        System.out.println(a);

        int b = plus(1, 2);
        System.out.println(b);

        int m = 3, n = 4;
        int c = plus(m, n);
        System.out.println(c);

        int[] d = testArray();
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
    }

    //无返回值，无参
    public static void say() {
        System.out.println("大家好");
    }

    //无返回值，有一个参
    public static void sayHi(String name) {
        System.out.println("大家好，我的名字是" + name);
    }

    //无返回值，有多个参
    public static void sayHello(String name, int age) {
        System.out.println("大家好，我的名字是" + name + "，年龄是" + age);
    }

    //有返回值，无参
    public static double getNum() {
        return 3.14159;
    }

    //有返回值，有参
    public static int plus(int num1, int num2) {
        return num1 + num2;
    }

    //有返回值，无参
    public static int[] testArray() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        return arr;
    }
}