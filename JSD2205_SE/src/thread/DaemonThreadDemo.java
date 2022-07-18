package thread;

/**
 * 守护线程：
 * 也称为“后台线程”，是通过普通线程（也称为用户线程）调用方法setDaemon(true)设置而转变的。
 * 守护线程在结束时机上与普通线程有一点不同，那就是在进程结束时。
 *
 * 进程结束：
 * 当java进程中所有普通线程都结束时，该进程就会结束，此时它会杀死所有还在运行的守护线程。
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread() {
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Rose: Let me go!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("哼啊啊啊啊啊！");
                System.out.println("噗通！");
            }
        };

        Thread jack = new Thread() {
            public void run() {
                while (true) {
                    System.out.println("Jack: You jump! I jump!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        //设置守护线程的工作（setDaemon()）必须在线程启动前（start()）进行
        //适合设置为守护进程的：别人停我也停，如GC（垃圾回收器）
        jack.setDaemon(true);

        rose.start();
        jack.start();

        //System.out.println("main方法执行完毕");
        while (true) ;
    }
}
