package io;

public class Test {
    public static void main(String[] args) {
        /*
            返回当前系统时间的毫秒值(UTC时间   世界协调时)
            从公元1970年1月1日 00:00:00开始的偏移量(单位是毫秒)
         */
        long m = System.currentTimeMillis();
        System.out.println(m);

        long max = Long.MAX_VALUE;
        max = max/1000/60/60/24/365;
        System.out.println("公元:"+(1970+max));
    }
}
