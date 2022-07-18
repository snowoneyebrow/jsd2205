package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的遍历：
 * Collection提供了同一的遍历集合的方式：迭代器模式
 * 对应的方法：
 * Iterator iterator()：
 * 该方法会返回一个用于遍历当前集合的迭代器
 * <p>
 * java.util.Iterator迭代器接口：
 * 所有的集合都提供了一个用于遍历自身元素的迭代器实现类，
 * 我们无需记住这些类的名字，只需要把它们当作Iterator去操作即可。
 * 迭代器遍历集合遵循的步骤为：问->取->删，
 * 其中删除元素不是遍历过程中的必要操作。
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        System.out.println(c);

        /*
            迭代器中两个重要的方法：
            boolean hasNext()：
            判断当前集合是否还有下一个元素可以遍历。
            注：迭代器默认开始位置为集合第一个元素之前，
            所以第一次调用是判断集合是否有第一个元素可以遍历。

            E next()：
            使迭代器向后移动到下一个元素的位置并获取该元素。
         */
        Iterator it = c.iterator();
        while (it.hasNext()) {
            //Object obj = it.next();
            //默认是Object类型，适用于任何类型
            //若很明确是某种类型比如String，则可以强转成String
            String str = (String) it.next();
            System.out.println(str);

            //迭代器在遍历的过程中不能通过集合的方式增删元素，否则会抛出异常!
            //迭代器提供的remove方法可以删除迭代器当前位置表示的集合元素
            if ("#".equals(str)) {
                //c.remove(str); //禁止的操作！
                it.remove(); //删掉后后面会自动补前
            }

            //ConcurrentModificationException：并发修改异常
            //迭代器：快速失败原则
            /*
            1：ConcurrentModificationException异常与modCount这个变量有关。
            2：modCount的作用：
            modCount就是修改次数，在具体的实现类中的Iterator中才会使用。在List集合中，ArrayList是List接口的实现类。
            modCount：表示list集合结构上被修改的次数。（在ArrayList所有涉及结构变化的方法中，都增加了modCount的值）
            list结构上被修改是指：改变了list的长度的大小或者是遍历结果中产生了不正确的结果的方式。
            add()和remove()方法会是modCount进行+1操作。
            modCount被修改后会产生ConcurrentModificationException异常，这是jdk的快速失败原则。
            3：modCount的变量从何而来。
            modCount被定义在ArrayList的父类AbstractList中，初值为0，protected transient int modCount = 0。
             */
        }
        System.out.println(c);
    }
}
