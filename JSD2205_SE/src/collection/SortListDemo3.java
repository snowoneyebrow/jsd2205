package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("C++");
        list.add("Python");
        list.add("Php");
        list.add("javascript");
        list.add("c#");
        list.add("kotlin");
        list.add("scala");
        list.add("苍老师");
        list.add("葵司老师");
        list.add("相泽南老师");
        list.add("河北彩花老师");
        list.add("波多野结衣老师");

        //Collections.sort(list); //按首字母的Unicode排序，所以大写字母在前面
        //Collections.sort(list, (o1, o2) -> o1.length() - o2.length()); //按字符串长度排序
        list.sort((o1, o2) -> o1.length() - o2.length());
        System.out.println(list);
    }
}
