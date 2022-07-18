package thread;

/**
 * java中所有代码都是靠线程运行的，main()方法也不例外。
 * 当JVM启动后就会创建一条线程来执行main()方法，并且该线程被赋予了一个名字也叫"main"，
 * 我们一般称它为“主线程”，但是它和我们创建的线程本身没有任何区别。
 *
 * 线程提供了一个静态方法：
 * static Thread currentThread()
 * 该方法可以获取运行该方法的线程
 */
public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main = Thread.currentThread(); //获取运行main()方法的线程
        System.out.println("主线程：" + main);
        dosome();
        //main()方法执行完毕意味着主线程结束了
    }

    public static void dosome() {
        Thread t = Thread.currentThread(); //获取运行dosome()方法的线程
        System.out.println("运行dosome()方法的线程是：" + t);
    }
}
