package collection;

import java.util.ArrayList;
import java.util.Collection;

//集合只能存放引用类型元素
//集合都把元素视为Object，不关心其具体类型
//集合存放的是元素的引用（地址）
public class CollectionDemo3 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        Point p = new Point(1, 2);
        c.add(p);

        System.out.println(p);
        System.out.println(c);

        p.setX(2);
        System.out.println(p);
        System.out.println(c);
    }
}
