package collection;

import java.util.ArrayList;
import java.util.List;

//List集合提供了一对重载的add、remove方法，也可以通过下标进行操作
public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);

        //void add(int index, E e)：将给定元素e插入到指定位置
        list.add(2, "six"); //将six插到下标2的位置，后面元素往后移
        System.out.println(list);

        //E remove(int index)：删除并返回指定位置上的元素
        String old = list.remove(3); //删除下标为3的元素，有返回值
        System.out.println(list);
        System.out.println(old);
    }
}
