package map;

import java.util.*;

/**
 * Map的遍历：
 * Map提供了三种遍历方式：
 * 1：遍历所有key
 * 2：遍历每一组键值对
 * 3：遍历所有value（相对不常用）
 */
public class MapDemo2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 99);
        map.put("数学", 98);
        map.put("英语", 97);
        map.put("物理", 96);
        map.put("化学", 99);
        System.out.println(map);

        /*
            遍历所有key：
            Set<K> keySet()：
            将当前Map中所有key以一个Set集合形式返回。
         */
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println("key：" + key);
        }

        /*
            遍历每一组键值对：
            Set entrySet()：
            将当前Map中每一组键值对以一个Entry实例形式表示，并将所有键值对存入Set后返回。
            java.util.Map.Entry的每一个实例表示一组键值对。
            两个常用方法：
            K getKey()
            V getValue()
         */
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "：" + value);
        }

        /*
            Collection values()：
            将当前Map中所有value以一个Collection形式返回。
         */
        //key不能重复，所以用Set。value可以重复，所以用Collection
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println("value：" + value);
        }

        //JDK8中集合和Map都提供了基于lambda表达式的遍历方式
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");

        for (String s : c) {
            System.out.println(s);
        }

        c.forEach(s -> System.out.println(s)); //消费者模式
        //@FunctionalInterface就是用来指定某个接口必须是函数式接口，函数式接口就是为Lambda表达式准备的

        map.forEach((k, v) -> System.out.println(k + "：" + v));
    }
}
