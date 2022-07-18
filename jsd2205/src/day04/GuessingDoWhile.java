package day04;

import java.util.Scanner;

public class GuessingDoWhile {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 1000) + 1;
        System.out.println(num);

        Scanner scan = new Scanner(System.in);
        int guess;

        do {
            System.out.println("猜吧");
            guess = scan.nextInt();
            if (guess > num) {
                System.out.println("太大了");
            } else if (guess < num) {
                System.out.println("太小了");
            } else {
                System.out.println("猜对了");
            }
        } while (guess != num);
    }
}
