package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JAVA 集合框架：
 * java.util.Collection接口，所有的集合都实现自该接口，
 * 该接口中定义了所有集合都必须具备的相关功能。
 * <p>
 * 集合与数组一样，可以保存一组元素，但是元素的相关操作都封装成了方法。
 * 集合有多种不同的数据结构，可根据实际应用场景选择最优的结构。
 * <p>
 * Collection下面有两个非常常见的子类集合：
 * java.util.List：线性表，是一个可以存放重复元素且有序的集合。
 * java.util.Set：是一个存放不可重复的元素且无序的集合。
 * 元素是否重复取决于相互的equals比较结果。
 * 元素是否有序指add添加的顺序是否与实际存储在集合中的顺序相同。
 */
public class CollectionDemo {
    //集合只能存放引用类型，8种基本类型不行
    //实际上能放8种基本类型是因为，自动装箱了
    public static void main(String[] args) {
        Collection c = new ArrayList(); //向上造型
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");

        //boolean add(E e)：添加一个元素，成功后返回true，返回值可以不接收
        System.out.println(c.add("five")); //List元素可以重复
        System.out.println(c);

        /*
        E是泛型
        初步理解泛型：
        假定我们有这样一个需求：写一个排序方法，
        能够对整型数组、字符串数组甚至其他任何类型的数组进行排序，该如何实现？
        答案是可以使用 Java 泛型。
        使用 Java 泛型的概念，我们可以写一个泛型方法来对一个对象数组排序。
        然后，调用该泛型方法来对整型数组、浮点数数组、字符串数组等进行排序。
         */

        //int size()：返回集合的元素个数
        //若集合元素个数超过Integer.MAX_VALUE，则返回Integer.MAX_VALUE
        //数组的length是数组的长度，不是存了几个元素
        //集合的size是存了几个元素，集合长度是不确定的
        int size = c.size();
        System.out.println("size:" + size);

        //boolean isEmpty()：判断集合是否为空集（空集：集合存在，但里面没元素）
        //size为0时isEmpty为true
        //集合=null意味着连集合都不存在
        boolean isEmpty = c.isEmpty();
        System.out.println("是否为空集:" + isEmpty);

        //void clear()：清空集合
        c.clear();
        System.out.println(c);
        System.out.println("size:" + c.size());
        System.out.println("是否为空集:" + c.isEmpty());
    }
}
