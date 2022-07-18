package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为List集合
 * 数组的工具类Arrays提供了一个静态方法asList，可以将一个数组转换为List集合
 * 数组只能转为List，不能转为Set，因为数组是可重复的
 */
public class ArrayToListDemo {
    public static void main(String[] args) {
        //Arrays.asList()
        String[] array = {"one", "two", "three", "four", "five"};
        System.out.println(array); //数组默认输出的是地址
        System.out.println(Arrays.toString(array));
        List<String> list = Arrays.asList(array);
        System.out.println(list);

        //数组转为集合后，对该集合的操作就是对原数组对应的操作
        list.set(1, "six");
        System.out.println(list);
        System.out.println(Arrays.toString(array)); //数组元素也相应改变

        //因为对该集合的操作就是对原数组对应的操作，而且数组定长，所以集合不支持增删元素操作，会抛出异常
        //java.lang.UnsupportedOperationException（不支持的操作异常）
        //list.add("seven");
        //System.out.println(list);
        //System.out.println(Arrays.toString(array));

        //若要增删集合元素，则要创建一个新集合并包含原集合所有元素
        //可以在创建集合时传一个集合类型的参数过去
        List list2 = new ArrayList(list);
        System.out.println(list2);
        list2.add("seven");
        System.out.println(list2);

        String[] array3 = {"one", "two", "three", "four", "five", "six", "seven"};
        ArrayList<String> list3 = new ArrayList<>(Arrays.asList(array3)); //一步到位的写法
        System.out.println(Arrays.toString(array3));
        System.out.println(list3);
        list3.add("eight");
        System.out.println(Arrays.toString(array3));
        System.out.println(list3);
    }
}
