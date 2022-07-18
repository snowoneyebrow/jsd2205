package thread;

import java.util.Scanner;

/**
 * sleep阻塞：
 *
 * 线程提供了一个静态方法：
 * static void sleep(long ms)
 * 当一个线程调用sleep()方法后就会进入指定毫秒数的阻塞状态
 */
public class SleepDemo {
    public static void main(String[] args) {
        //倒计时程序：
        //程序启动后要求输入一个数字，从该数字开始每秒递减，到0时输出时间到。

        System.out.println("程序开始了");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = scanner.nextInt();
        for (int i = num; i > 0; i--) {
            try {
                Thread.sleep(1000); //java没办法精准控制时间，误差比较大
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("时间到");

        System.out.println("程序结束了");
    }
}
