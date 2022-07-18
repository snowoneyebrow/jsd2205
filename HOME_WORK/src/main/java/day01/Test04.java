package day01;

import java.util.Scanner;

/**
 * 要求用户从控制台输入一个email地址，然后获取该email的用户名(@之前的内容)
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		String email = new Scanner(System.in).nextLine();
		String[] s = email.split("@");
		System.out.println("用户名:"+s[0]);
	}
}
