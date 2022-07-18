package day04;

import java.util.Scanner;

public class ScoreLevel {
    public static void main(String[] args) {
        System.out.println("请输入成绩：");
        Scanner scan = new Scanner(System.in);
        double score = scan.nextDouble();

        if (score < 0 || score > 100) {
            System.out.println("输入的成绩非法");
        } else if (score >= 90) {
            System.out.println("成绩为A");
        } else if (score >= 80) {
            System.out.println("成绩为B");
        } else if (score >= 60) {
            System.out.println("成绩为C");
        } else {
            System.out.println("成绩为D");
        }


    }
}
