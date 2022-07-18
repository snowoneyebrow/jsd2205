package thread;

//查看线程相关信息的一组方法
public class ThreadInfoDemo {
    public static void main(String[] args) {
        //获取主线程
        Thread main = Thread.currentThread();

        //获取线程的名字
        String name = main.getName();
        System.out.println(name);

        //获取线程的唯一标识
        long id = main.getId(); //注意是long类型！
        System.out.println(id);

        //获取线程的优先级
        //是一个数字，范围在1-10之间
        //10最高优先级，1最低优先级，5普通优先级（默认）
        int priority = main.getPriority();
        System.out.println("优先级：" + priority);

        //注意：is开头的方法返回值为boolean！

        //查看是否为守护线程
        boolean daemon = main.isDaemon(); //daemon：守护线程

        //查看是否活着
        boolean alive = main.isAlive();

        //查看是否被中断了
        boolean interrupted = main.isInterrupted(); //interrupt：中断

        System.out.println("是否为守护线程：" + daemon);
        System.out.println("是否活着：" + alive);
        System.out.println("是否被中断：" + interrupted);
    }
}
