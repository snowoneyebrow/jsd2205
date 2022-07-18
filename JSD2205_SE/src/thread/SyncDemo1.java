package thread;

/**
 * 多线程并发安全问题：
 * 当多个线程并发操作同一临界资源，由于线程切换实际不确定，导致操作顺序出现混乱，从而导致程序bug或更严重的程序问题。
 * 通俗的讲就是当多个线程同时“抢”同一个东西产生了混乱。
 * <p>
 * 临界资源：同一时刻只能被单线程操作的资源称为临界资源。
 */
public class SyncDemo1 { //Sync：同步
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    int bean = table.getBean();
                    Thread.yield();
                    System.out.println(getName() + ":" + bean);
                }
            }
        };
        t1.start();
        t2.start();
    }
}

class Table {
    private int beans = 20; //桌子上有20个豆子

    /*
        当一个方法使用synchronized修饰后，该方法称为同步方法。即：多个线程不能同时在内部一起执行
        将多个线程并发操作同一临界资源改为同步执行（排队，有先后顺序的）就可以有效的解决多线程的并发安全问题。
     */
    public synchronized int getBean() { //synchronized：同步的
        //异步
        //线程1执行完了，外面等的线程2、3、4、5谁先进，不是按顺序来，而是看下次时间片先分配给谁
        if (beans == 0) { //桌子上没有豆子了
            throw new RuntimeException("没豆子了！");
        }
        Thread.yield(); //让线程主动放弃当前时间片
        return beans--;
    }
}

/*
Thread-0:20
Thread-1:19
Thread-0:18
Thread-1:17
Thread-0:16
Thread-1:15
Thread-0:14
Thread-1:13
Thread-0:12
Thread-1:11
Thread-0:10
Thread-1:9
Thread-0:8
Thread-1:7
Thread-0:6
Thread-1:5
Thread-0:4
Thread-1:3
Thread-1:1
Thread-0:2
Exception in thread "Thread-0" Exception in thread "Thread-1" java.lang.RuntimeException: 没豆子了！
	at thread.Table.getBean(SyncDemo1.java:45)
	at thread.SyncDemo1$2.run(SyncDemo1.java:25)
java.lang.RuntimeException: 没豆子了！
	at thread.Table.getBean(SyncDemo1.java:45)
	at thread.SyncDemo1$1.run(SyncDemo1.java:16)
 */
