package homework.day08;

import java.util.ArrayList;
import java.util.Random;

//生成10个0-100之间的不重复的随机数，并输出
public class Test03 {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int r = random.nextInt(101); //0到100，含头不含尾
            if (array.contains(r)) {
                i--;
            } else {
                array.add(r);
            }
        }
        for (int i : array) {
            System.out.println(i);
        }
    }
}
