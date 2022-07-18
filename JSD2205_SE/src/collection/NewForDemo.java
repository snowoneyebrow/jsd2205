package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * JDK5推出了一个新特性：增强for循环，使得我们可以用相同的语法遍历集合或数组。
 * 语法：
 * for(元素类型 变量名 : 遍历的集合或数组){
 * ...
 * }
 * <p>
 * 注意：新循环并不能取代传统for循环的工作，因为他仅用于遍历集合或数组，不能增删元素。
 */
public class NewForDemo {
    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "four", "five"};

        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            System.out.println(str);
        }

        //编译器会把新循环改为传统的for循环来遍历数组
        for (String str : array) {
            System.out.println(str);
        }

        /*
            泛型：JDK5推出的另一个特性，又称为参数化类型（把类型作为参数传进去）
            泛型在集合中被广泛应用，用来指定该集合的元素类型（相当于约束了集合的元素类型）。
            注：泛型不指定时，使用原型Object。
         */
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);

        /*
            增强for循环遍历集合会被编译器改回成迭代器遍历，只是为了写法更优雅。
            因此注意：遍历的过程中不能通过集合的方法增删元素，否则会抛出异常。
         */
        for (String str : c) {
            System.out.println(str);
        }

        //迭代器需要指定泛型，具体类型应与其遍历的集合指定的泛型一致
        //迭代器指定泛型后，获取元素则无需手动向上造型
        Iterator<String> it = c.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }
    }
}
