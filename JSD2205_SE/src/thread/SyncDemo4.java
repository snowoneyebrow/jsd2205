package thread;

/**
 * 互斥锁：
 * 当使用多个synchronized锁定多个代码片段，但是指定的锁对象相同时，这些代码片段就是互斥的
 * 即：多个线程不能同时执行这些代码片段
 */
public class SyncDemo4 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        Thread t1 = new Thread() {
            public void run() {
                foo.methodA();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                foo.methodB();
            }
        };
        t1.start();
        t2.start();
    }
}

class Foo {
    //在成员方法上使用synchronized时，同步监视器对象就是当前方法的所属对象this。
    public synchronized void methodA() {
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ":正在执行A方法...");
            Thread.sleep(2000);
            System.out.println(t.getName() + ":执行A方法完毕!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        synchronized (this) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ":正在执行B方法...");
                Thread.sleep(2000);
                System.out.println(t.getName() + ":执行B方法完毕!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
