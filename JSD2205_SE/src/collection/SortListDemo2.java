package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//排序那些元素是自定义类型的集合
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(13, 14));
        list.add(new Point(11, 12));
        list.add(new Point(9, 10));
        list.add(new Point(7, 8));
        list.add(new Point(5, 6));
        list.add(new Point(3, 4));
        list.add(new Point(1, 2));
        System.out.println(list);

        /*
            使用该sort方法排序List集合时有一个前提条件：集合元素必须实现了Comparable接口
            sort方法会利用该接口定义的抽象方法对元素两两比较得知大小后进行排序。
            若元素没有实现该接口则编译不通过。

            该操作具有侵入性：当我们使用一个API时，如果该API反过来要求我们的程序为其修改其它额外地方的代码，
            那么就具有了侵入性，这不利于我们程序的后期维护。
         */

        //回调模式
        /*
        当我们要实现一个通用的排序函数时，事先并不知道其他开发者会用该函数来对哪些类型的元素进行排序，
        也就不知道以何种标准来判断这些元素的偏序（大小）关系。
        因此，可以要求其他开发者在使用排序函数时，必须提供一个比较函数 compare，
        这样我们就可以用 compare 比较待排序元素的大小，
        而无需事先知道元素是什么类型，也无需知道 compare 的具体实现。
        这里 compare 函数对于排序函数来说，就是回调函数。
         */
        Comparator<Point> c = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) { //以点到原点的距离进行比较
                int len1 = o1.getX() * o1.getX() + o1.getY() * o1.getY();
                int len2 = o2.getX() * o2.getX() + o2.getY() * o2.getY();
                //^运算符不是平方！是异或（相同为0，不同为1）
                //Math中有平方的运算：Math.pow(x,y)：求x的y次方
                return len1 - len2; //从小到大
                //return len2 - len1; //从大到小
                //规则：
                //返回负数，意味着第一个参数比第二个参数小
                //返回0，意味着第一个参数与第二个参数相等
                //返回正数，意味着第一个参数比第二个参数大
            }
        };
        Collections.sort(list, c);

        //lambda表达式写法
        Collections.sort(list, (o1, o2) -> o1.getX() * o1.getX() + o1.getY() * o1.getY() - o2.getX() * o2.getX() - o2.getY() * o2.getY());
        System.out.println(list);
    }
}
