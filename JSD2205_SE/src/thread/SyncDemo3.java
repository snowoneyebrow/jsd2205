package thread;

//若在静态方法上使用synchronized，则该方法一定具有同步效果，一定是分开做。
public class SyncDemo3 {
    public static void main(String[] args) {
        Boo b1 = new Boo();
        Boo b2 = new Boo();
        Thread t1 = new Thread() {
            public void run() {
                b1.dosome();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                b2.dosome();
            }
        };
        t1.start();
        t2.start();
    }
}

class Boo {
    /*
        静态方法上使用synchronized后，那么同步监视器对象为当前类的类对象。即：Class的实例。
        知识引入：JVM中每一个被加载的类都有且只有一个Class的实例与之对应，该实例称为这个类的类对象。
                获取类对象的方式：类名.class
        该知识点会在后期反射中详细说明
     */
    //public static synchronized void dosome(){
    public static void dosome() {
        //静态方法的同步块中依然应当使用当前类的类对象作为锁对象
        synchronized (Boo.class) {
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ":正在执行dosome方法...");
                Thread.sleep(2000);
                System.out.println(t.getName() + ":执行dosome方法完毕!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
