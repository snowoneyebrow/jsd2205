package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

//集合之间的操作
public class CollectionDemo4 {
    public static void main(String[] args) {
        //ArrayList：重复，有序，元素类型可以不同
        Collection c1 = new ArrayList();
        c1.add("java");
        c1.add("c++");
        c1.add("python");
        System.out.println(c1);

        //HashSet：不重复，无序
        Collection c2 = new HashSet();
        c2.add("android");
        c2.add("ios");
        c2.add("java"); //c1中重复的元素
        System.out.println(c2);

        //将一个集合的元素添加到另外一个集合
        //c1.addAll(c2); //addAll后元素重复了，有序
        //System.out.println(c1);
        c2.addAll(c1);
        System.out.println(c2);

        Collection c3 = new ArrayList();
        c3.add("java");
        c3.add("c++");

        //判断当前集合是否包含给定集合中的所有元素（真包含，子集）
        boolean containsAll = c1.containsAll(c3);
        System.out.println(containsAll);
        c3.add("php");
        containsAll = c1.containsAll(c3);
        System.out.println(containsAll);

        //contains与containsAll不同，contains是把c3整体当成c1的一个元素看待
        containsAll = c1.contains(c3);
        System.out.println(containsAll);

        System.out.println(c1);
        System.out.println(c3);
        //取交集，c1保留两者共有的元素
        //c1.retainAll(c3);
        //删交集，c1删除两者共有的元素
        c1.removeAll(c3);
        System.out.println(c1);
        System.out.println(c3);
    }
}
