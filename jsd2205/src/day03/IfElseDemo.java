package day03;

public class IfElseDemo {
    public static void main(String[] args) {
        int num = 6;
        if (num % 2 == 0) {
            System.out.println(num + "是偶数");
        } else {
            System.out.println(num + "是奇数");
        }
        System.out.println("继续执行......");

        double price = 300.0;
        if (price >= 500) {
            price *= 0.8;
        } else {
            price *= 0.9;
        }
        System.out.println("打折后金额为：" + price);


    }
}
