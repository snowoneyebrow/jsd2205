package apiday02;

public class ObjectDemo {
    public static void main(String[] args) {
        /*
        调用Object类的equals()，内部还是使用==来比较地址的，没有实际意义
        若想比较对象的属性值是否相同，通常需要重写equals()
        类一旦重写了equals()，则会调用重写之后的equals()
        */
        Point p1 = new Point(100, 200);
        Point p2 = new Point(100, 200);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2)); //false，==比较的是地址

        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);

        //String重写了equals()，但StringBuilder没有
        StringBuilder s12 = new StringBuilder("hello");
        StringBuilder s34 = new StringBuilder("456");
        System.out.println(s12 == s34);

        System.out.println(s1.equals(s12.toString()));

    }
}
