package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; //concurrent：并发

/*
线程池：
线程池是线程的管理机制，主要解决两方面问题：
1、控制线程的数量
2、重用线程
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(2); //线程数量

        for (int i = 0; i < 5; i++) {
            /*
            以下三行：
            Runnable r = new Runnable() {
                @Override
                public void run() {
            可替换为：
            Runnable r = () -> {
             */
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    Thread t = Thread.currentThread(); //获取当前线程
                    System.out.println(t.getName() + "正在执行任务。。。");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        //当阻塞的方法收到中断请求时会抛出InterruptedException异常
                        e.printStackTrace();
                    }
                    System.out.println(t.getName() + "任务执行完毕！");
                }
            };
            threadPool.execute(r); //将任务指派给线程池
        }

        threadPool.shutdown(); //关闭线程池，但是会把正在执行的线程执行完
        threadPool.shutdownNow(); //关闭线程池，立刻停止所有线程
        System.out.println("线程池停止了！");
    }
}
