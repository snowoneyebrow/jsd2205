package day04;

import java.util.Scanner;

public class day04_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入金额：");
        double price = scan.nextDouble();

        if (price >= 1000) {
            price *= 0.7;
        } else if (price >= 500) {
            price *= 0.8;
        } else if (price >= 0) {
            price *= 0.9;
        }
        if (price < 0) {
            System.out.println("输入错误");
        } else {
            System.out.println("打折后金额为：" + price);
        }

    }
}
