package apiday02;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        System.out.println(str.replaceAll("\\D{1}", "*"));
    }
}
