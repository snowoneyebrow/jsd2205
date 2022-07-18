package thread;

/**
 * 线程的优先级：
 * 当一个线程调用start()方法后，就被纳入到线程调度器中被统一管理，
 * 此时线程只能被动地被分配时间片并发运行，并不能主动索取时间片。
 * 而线程调度器会尽可能均匀地分配时间片给每个线程。
 * 通过调整线程的优先级可以最大程度地改善获取时间片的概率。
 * 优先级越高的线程获取时间片的次数越多。
 *
 * 线程的优先级有10个等级，分别用整数1-10表示。其中1最低，5为默认值，10最高。
 * 也可以使用Thread提供的常量：MIN_PRIORITY，NORM_PRIORITY，MAX_PRIORITY。
 * 分别表示：最低优先级，默认优先级，最高优先级
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("min");
                }
            }
        };

        Thread max = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("max");
                }
            }
        };

        Thread normal = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println("normal");
                }
            }
        };

        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        //normal.setPriority(Thread.NORM_PRIORITY); //默认的，不用设置

        min.start();
        max.start();
        normal.start();
    }
}
