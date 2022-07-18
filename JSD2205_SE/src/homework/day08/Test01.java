package homework.day08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//改错题
//程序需求：向一个List集合中添加10个数字1-10，并将它们遍历出来并输出到控制台。
public class Test01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int i = it.next();
            System.out.println(i);
        }
    }
}
