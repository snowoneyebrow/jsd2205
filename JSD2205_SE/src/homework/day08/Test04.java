package homework.day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//将整数1-100存入一个List集合中并输出，之后将集合中40-60的元素翻转后并输出
public class Test04 {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            array.add(i);
        }
        System.out.println(Arrays.toString(array.toArray()));
        Collections.reverse(array.subList(39, 60));
        //下标0对应1，下标39对应40，下标59对应60，含头不含尾
        System.out.println(Arrays.toString(array.toArray()));
    }
}
