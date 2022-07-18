package thread;

/**
 * 实验：
 * 在main()方法中定义两个线程，各自循环10000次，每次循环时对num++。
 * 当两个线程执行完毕后，查看num的值是多少？
 */
public class Test2 {
    public static int num = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    num++;
                }
                System.out.println("线程结束了！");
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    num++;
                }
                System.out.println("线程结束了！");
            }
        };

        t1.start();
        t2.start();

        //可能线程2循环判断完就没时间片了，cpu转到线程1，导致线程2的num没自增，所以num的最终结果小于2w

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
