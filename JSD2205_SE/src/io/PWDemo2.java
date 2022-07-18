package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        FileOutputStream fos = new FileOutputStream("./pw2.txt", true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw, true); //只有println才能自动刷新，print不行

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入：");
            String s = scan.nextLine();
            if ("exit".equalsIgnoreCase(s)) {
                System.out.println("程序退出");
                break;
            }
            pw.println(s);
            System.out.println("保存成功");
        }
        pw.close();
    }
}
