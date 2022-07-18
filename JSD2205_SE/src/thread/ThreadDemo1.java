package thread;

/**
 * 多线程：
 * 多线程可以并发执行多个代码片段
 *
 * 线程的第一种创建方式：
 * 继承Thread类重写run()方法
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();

        //线程运行需要调用start()方法，而不是直接调用run()方法！
        //当start()方法执行完毕，线程的run()方法很快会被自动执行。
        t1.start();
        t2.start();
    }
}

/*
    该种方式创建线程的优点：
    结构简单，利于匿名内部类形式的创建。

    缺点：
    1：存在继承冲突问题，因为java是单继承，所以继承了Thread类就无法再继承其它类去复用方法。
    2：定义线程的同时就将任务定义在里面（重写了run()方法），这导致线程与任务存在了必然的紧密耦合关系，不利于线程的复用。
 */
class MyThread1 extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("你是谁啊？");
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("开门！查水表的！");
        }
    }
}
