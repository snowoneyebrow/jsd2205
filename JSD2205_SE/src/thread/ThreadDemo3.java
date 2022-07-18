package thread;

/**
 * 线程的第三种创建方式：
 * 使用匿名内部类结合上述两种形式或者lambda表达式完成线程的创建
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //使用匿名内部类，继承Thread类重写run()方法
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("你是谁啊？");
                }
            }
        };

        //使用匿名内部类，实现Runnable接口来单独定义线程任务
        Runnable r2 = new Runnable() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("我是查水表的！");
                }
            }
        };
        Thread t2 = new Thread(r2);

        //lambda表达式
        Thread t3 = new Thread(() -> { //没参数也要写括号
            for (int i = 0; i < 1000; i++) {
                System.out.println("你是谁啊？");
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
