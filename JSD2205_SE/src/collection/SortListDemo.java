package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 对List集合的排序：
 * java.util.Collections是集合的工具类，里面提供了很多静态方法便于我们操作集合
 * 其中提供了一个静态方法sort()可以对List集合进行自然排序
 * 注：JDK8时List集合自身也提供了sort()方法，具有同样的效果
 */
public class SortListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        Collections.sort(list); //注意是Collections！
        System.out.println(list);
    }
}
