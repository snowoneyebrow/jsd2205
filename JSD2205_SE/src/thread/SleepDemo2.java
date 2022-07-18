package thread;

/**
 * sleep方法要求我们必须处理中断异常：InterruptedException
 * 当一个线程调用sleep()方法处于睡眠阻塞的过程时，若该线程的interrupt()方法被调用，
 * 那么此时会强制中断它的睡眠阻塞并抛出异常InterruptedException。
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread() {
            public void run() {
                System.out.println("sleep~");
                try {
                    Thread.sleep(500000000);
                } catch (InterruptedException e) {
                    //强制唤醒后的代码放这里
                    System.out.println("what?");
                }
                System.out.println("wake!");
            }
        };

        Thread huang = new Thread() {
            public void run() {
                System.out.println("big 80,small 40,begin!");
                for (int i = 0; i < 5; i++) {
                    System.out.println("80!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        //不能直接throw抛异常，因为这是额外异常，Runnable没有
                    }
                }
                System.out.println("down!");
                System.out.println("bro!ok!");
                lin.interrupt(); //强行打断lin的sleep
            }
        };

        lin.start();
        huang.start();
    }
}
