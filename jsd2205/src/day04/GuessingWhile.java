package day04;

import java.util.Scanner;

public class GuessingWhile {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 1000) + 1;
        System.out.println(num); //作弊

        System.out.println("请输入一个数：");
        Scanner scan = new Scanner(System.in);
        int guess = scan.nextInt();

        while (guess != num) {
            if (guess > num) {
                System.out.println("太大了");
            } else {
                System.out.println("太小了");
            }
            System.out.println("猜吧");
            guess = scan.nextInt();

        }
        System.out.println("猜对了");
    }
}
