package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合转换为数组
 * Collection提供了方法：toArray()可以将一个集合转换为数组
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);

        //Object[] array = c.toArray();
        String[] array = c.toArray(new String[c.size()]);
        //c.size()可替换为比他大的数，比他小的数，0，都可以
        //传过来的数组能用就用，不能用就用自己的，传参是为了知道要创建什么类型的数组
        //若是比他大的数，则把集合转为数组后，后面多余的元素是默认值null
        //对ArrayList来说，给0会快一点
    }
}
