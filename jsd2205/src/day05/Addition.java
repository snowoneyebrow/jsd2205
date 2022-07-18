package day05;

import java.util.Scanner;

//随机加法运算器
public class Addition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = 0;
        for (int i = 1; i <= 10; i++) { //10道题
            int a = (int) (Math.random() * 100); //0到99
            int b = (int) (Math.random() * 100);
            int result = a + b;
            System.out.println("(" + i + ")" + a + "+" + b + "=?");
            System.out.println("算吧！（输入-1退出程序）");
            int answer = scan.nextInt();
            if (answer == -1) { //选答案不可能出现的数即可
                break;
            }
            if (answer == result) {
                System.out.println("答对了！");
                score += 10; //答对1题，加10分
            } else {
                System.out.println("答错了！"); //答错1题，不扣分
            }
        }
        System.out.println("总分为:" + score);
    }
}
