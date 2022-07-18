package collection;

import java.util.ArrayList;
import java.util.Collection;

//集合受元素equals方法影响的操作
public class CollectionDemo2 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add(new Point(1, 2));
        c.add(new Point(3, 4));
        c.add(new Point(5, 6));
        c.add(new Point(7, 8));
        c.add(new Point(9, 10));
        c.add(new Point(1, 2));
        //集合重写了toString方法，格式为：[元素1.toString()...]，输出的是地址
        //如果要输出元素的值就要重写元素的toString方法
        System.out.println(c);

        //boolean contains(Object o)：判断集合是否包含元素o
        //判断逻辑：该元素与集合现有元素进行equals比较，若为true则认为包含。
        //集合重写的equals方法默认比较的是地址，所以要比较值就要重写元素的equals方法。
        Point p = new Point(1, 2);
        boolean contains = c.contains(p);
        System.out.println("集合是否包含元素p:" + contains);

        //remove方法也是删除与给定元素equals比较为true的集合元素
        //但是！对于List集合这种可以存放重复元素的而言，仅会删除第一个equals比较为true的元素
        c.remove(p);
        System.out.println(c);
    }
}
