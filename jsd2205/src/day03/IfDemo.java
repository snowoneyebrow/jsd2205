package day03;

public class IfDemo {
    public static void main(String[] args) {
        int num = 5;
        if (num % 2 == 0) {
            System.out.println(num + "是偶数");
        }
        System.out.println("继续执行...");

        double price = 600.0;
        if (price >= 500) {
            // price = price * 0.8;
            price *= 0.8;
        }
        System.out.println("最终结算金额为：" + price);
    }
}
