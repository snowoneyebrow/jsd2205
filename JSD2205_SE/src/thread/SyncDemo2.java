package thread;

/**
 * 同步块的使用：
 * 有效的缩小同步范围可以在保证并发安全的前提下尽可能的提高并发效率。
 * <p>
 * 语法：
 * synchronized(同步监视器对象){
 * 需要多个线程同步执行的代码片段
 * }
 * <p>
 * 同步和异步执行：这两种执行都是指多线程的执行。
 * 同步执行：多个线程的执行过程出现了先后顺序。
 * 异步执行：多个线程各执行各的，之间没有顺序。
 */
public class SyncDemo2 {
    public static void main(String[] args) {
        //"hello"（字符串字面量）作为锁对象的例子
        //Shop shop1 = new Shop();
        //Shop shop2 = new Shop();

        Shop shop = new Shop();
        Thread t1 = new Thread("范传奇") { //给线程起名字，getName()可以获取名字
            public void run() {
                //shop1.buy();
                shop.buy();
            }
        };
        Thread t2 = new Thread("王克晶") {
            public void run() {
                //shop2.buy();
                shop.buy();
            }
        };
        t1.start();
        t2.start();
    }
}

class Shop {
    //在成员方法上使用synchronized时，同步监视器对象就是当前方法的所属对象this。
    //public synchronized void buy(){
    public void buy() {
        try {
            Thread t = Thread.currentThread(); //获取运行buy方法的线程
            System.out.println(t.getName() + ":正在挑衣服...");
            Thread.sleep(2000);
            /*
                在使用同步块时要指定同步监视器对象(上锁的对象)
                该对象必须同时满足以下两个条件：
                1：必须是一个引用类型
                2：多个需要同步执行该代码片段的线程看到的这个锁对象必须为【同一个】！
             */

            synchronized (this) {
                //可以，因为t1和t2调用的是同一个shop的buy方法，因此方法内的this是同一个shop对象
                //作用的对象是调用这个代码块的对象，谁调就是谁
                //Shop对象调的buy()方法，所以this指的是Shop对象

                //synchronized (t) {
                //不可以，因为t1和t2调用buy方法时获取的就是线程自身，因此t是不同的线程。
                //如果这里写t，编译也能通过，但实际运行没实现同步的效果
                //因为t是buy()方法定义的当前线程，可能是t1线程也可能是t2线程，
                //相当于t1进来了锁自己，t2进来了锁自己，没实现同步的效果

                //synchronized (new Object()) {
                //不可以，有new一定不行！因为new一定产生新对象

                //synchronized ("hello") {
                /*
                    当"hello"（字符串字面量）作为锁对象时，由于java对字符串的优化机制，所以字面量始终是同一个对象，
                    这会导致当t1和t2线程调用不同shop的buy方法时（相当于两个人进不同的商店买衣服），
                    由于在这里看到的锁对象相同，所以仍然需要排队执行，这就是不合理的操作了。
                    排队执行的前提是存在并发安全问题（有"抢"这件事发生）。
                 */

                System.out.println(t.getName() + ":正在试衣服...");
                Thread.sleep(2000);
            }
            System.out.println(t.getName() + ":结账离开");
        } catch (InterruptedException e) {

        }
    }
}
