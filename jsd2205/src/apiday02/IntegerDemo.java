package apiday02;

public class IntegerDemo {
    public static void main(String[] args) {
        /*
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);

        //Integer.valueOf()复用-128到127，不会重新分配对象，建议使用
        Integer i3=Integer.valueOf(128);
        Integer i4=Integer.valueOf(128);
        System.out.println(i3 == i4);

        Integer i = 1; //自动装箱
        int j = i; //自动拆箱

         */

        int max1 = Integer.MAX_VALUE;
        int min1 = Integer.MIN_VALUE;
        System.out.println(max1 + "," + min1);

        long max2 = Long.MAX_VALUE;
        long min2 = Long.MIN_VALUE;
        System.out.println(max2 + "," + min2);

        String s1 = "38";
        int age = Integer.parseInt(s1);
        System.out.println(age);

        String s2="123.456";
        double a2=Double.parseDouble(s2);
        System.out.println(a2);



    }
}
