package day03;

public class OperDemo {
    public static void main(String[] args) {
        /*
        int a = 10, b = 20;
        int c = a++;
        int d = ++b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);


         */

        /*
        int a=10,b=20;
        int c=a--;
        int d=--b;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

         */

        /*
        int a = 5, b = 10, c = 5;
        System.out.println(c < b);
        System.out.println(b >= a);
        System.out.println(a <= c);
        System.out.println(a == c);
        System.out.println(a != c);
        System.out.println(a + c > 10);
        System.out.println(a % 2 == 0);
        System.out.println(a++ > 5);
        System.out.println(a++ > 5);

         */

        /*
        int a = 5, b = 10, c = 5;
        System.out.println(b >= a && b < c);
        System.out.println(b <= c && b > a);
        System.out.println(a == b && c > b);
        System.out.println(b != c && a < b);

         */
        /*
        int a = 5, b = 10, c = 5;
        System.out.println(b >= a || b < c);
        System.out.println(b <= c || b > a);
        System.out.println(b != c || a < b);
        System.out.println(a == b || c > b);

        boolean b2 = !(a > b);
        System.out.println(b2);
        System.out.println(!(a < b));

         */

        /*
        int a = 5, b = 10, c = 5;

        boolean b3 = a > b && c++ > 2;
        System.out.println(b3);
        System.out.println(c);

        boolean b4 = a < b || c++ > 2;
        System.out.println(b4);
        System.out.println(c);

         */


        //单杠的不短路


        /*
        short s = 25;
        //s=s+10;
        s += 10;
        System.out.println(s);

        int a = 5;
        a += 10;
        System.out.println(a);
        a *= 2;
        System.out.println(a);
        a /= 6;
        System.out.println(a);
        a -= 3;
        System.out.println(a);
         */

        /*
        int age = 38;
        System.out.println("age=");
        System.out.println(age);
        System.out.println("age=" + age);
        System.out.println("我的年龄是" + age);
        System.out.println("我今年" + age + "岁了");

        String name = "WKJ";
        System.out.println("大家好，我叫" + name);
        System.out.println("大家好，我叫" + name + "，今年" + age + "岁了");

         */

        int num = 5;
        int flag = num > 0 ? 1 : -1;
        System.out.println(flag);

        int a = 8, b = 5;
        int min = a < b ? a : b;
        System.out.println("最小值为：" + min);


    }
}
