package reflect;

import java.util.Arrays;

//可变长参数
public class ArgsDemo {
    public static void main(String[] args) {
        dosome(1, "a", "b", "c"); //dosome(new String[]{"a","b"});
    }

    //可变长参数会被编译器改为数组。
    //可变长参数只能是方法的【最后一个】参数。（暗示可变长参数只能有一个）
    public static void dosome(int d, String... s) { //(String[] s)
        System.out.println(s.length);
        System.out.println(Arrays.toString(s));
    }
}
