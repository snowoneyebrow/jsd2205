package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * List集合：
 * java.util.List接口：线性表，是可以存放重复元素且有序的集合。
 * 常见实现类：
 * java.util.ArrayList：内部使用数组实现，查询性能更好。
 * java.util.LinkedList：内部使用链表实现，增删性能更好，首尾增删性能最佳。
 * 实际开发中对性能没有特别苛刻的情况下，通常使用ArrayList。
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); //LinkedList也可
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);

        /*
            List集合提供了一套通过下标操作元素的方法：
            E get(int index)：获取指定下标处的元素
            E set(int index,E e)：将元素e存入下标index处，返回值为该位置原有的元素。（相当于替换元素）
         */
        String str = list.get(2);
        System.out.println(str);

        for (int i = 0; i < list.size(); i++) {
            str = list.get(i);
            System.out.println(str);
        }

        String old = list.set(2, "six");
        System.out.println(list);
        System.out.println(old);

        //小算法题：
        //在不创建新集合的前提下，将集合list的元素反转
        //思路：正数位置的元素和倒数位置的元素交换

        List<String> list1 = new ArrayList<>();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.add("four");
        list1.add("five");

        //作弊做法：
        //Collections.reverse(list1);

        //自写：
        /*
        System.out.println(list1);
        int len = list1.size();
        int i = 0;
        while (i < len - 1 - i) {
            String str1 = list1.get(i);
            String str2 = list1.get(len - 1 - i);
            list1.set(len - 1 - i, str1);
            list1.set(i, str2);
            i++;
        }
        System.out.println(list1);
         */

        System.out.println(list1);
        for (int j = 0; j < list1.size() / 2; j++) {
            String s = list1.get(j);
            s = list1.set(list1.size() - 1 - j, s);
            list1.set(j, s);
        }
        System.out.println(list1);
    }
}
