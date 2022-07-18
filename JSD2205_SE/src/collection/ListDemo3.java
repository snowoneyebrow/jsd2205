package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List subList(int start, int end)
 * 获取当前List集合中指定范围的子集。注意，含头不含尾！
 */
public class ListDemo3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        List<Integer> subList = list.subList(3, 8); //含头不含尾！
        System.out.println(subList);

        for (int i = 0; i < subList.size(); i++) {
            subList.set(i, subList.get(i) * 10);
        }
        System.out.println(subList);
        //对子集subList的操作就是对原集合list对应元素的操作！
        System.out.println(list);

        //利用子集的上述特点删除原集合的元素（用clear()）
        list.subList(2, 9).clear(); //含头不含尾！
        System.out.println(list);
    }
}
