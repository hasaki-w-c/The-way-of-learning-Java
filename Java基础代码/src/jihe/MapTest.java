package jihe;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
|-->Map接口：双列集合，用来存储一对（key--value）一对的数据 --> 类似与高中函数：y = f(x)
        |---HashMap：作为Map的主要实现类：线程不安全的，效率高；存储null和value
            |---LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实现遍历。
                    原因：在原有的HashMap底层结构上，添加了一对指针，指向前一个和后一个元素。
                    对于频繁的遍历操作，此类执行效率高于HashMap。
        |---TreeMap：保证按照添加的key-value对进行排序，实现排序遍历。按照key的自然排序进行排序。
                    底层使用红黑树
        |---Hashtable：作为古老的实现类；线程安全；效率低；不能存储null和value
            |---Properties：常用来处理配置文件。key和value都是String类型

    HashMap的底层实现：数组 + 链表 （JDK7之前）
                     数组 + 链表 + 红黑树 （JDK8）

面试题：
1.HashMap的底层实现原理？（高频）
2.HashMap和Hashtable的异同？
3.CurrentHashMap 与 Hashtable的异同？

Map结构的理解：
    Map中的key：无序的、不可重复的，使用Set存储所有的key  --->key所在的类要重写equals()和hashCode()(以hashMap为例)
    Map中的value：无序的、可重复的，使用Collection存储所有的value  --->value所在的类要重写equals()
    一个键值对：key-value构成了一个Entry对象。
    Map中的entry：无序的、不可重复的，使用Set存储所有的entry

 */
public class MapTest {
    /**
     * 添加删除的操作
     * put(K key, V value):将指定的值与该映射中的指定键相关联（可选操作）。
     * void putAll(Map<? extends K,? extends V> m):将指定Map的所有映射复制到此映射（可选操作）。
     * V remove(Object key):如果存在（从可选的操作），从该Map中删除一个键的映射。
     * default boolean remove(Object key, Object value):仅当指定的密钥当前映射到指定的值时删除该条目。
     * void clear()：从该Map中删除所有的映射（可选操作）。
     * int size():返回此地图中键值映射的数量。
     */
    @Test
    public void test1() {
        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",123);
        //修改
        map.put("AA",321);

        System.out.println(map);
        //{AA=321, BB=123, 45=123}

        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        map.putAll(map1);

        System.out.println(map);
        //{AA=321, BB=123, CC=123, DD=123, 45=123}

        //remove(key)
        Object value = map.remove("CC");
        System.out.println(value);
        //123

        System.out.println(map);
        //{AA=321, BB=123, DD=123, 45=123}

        //clear()
        map1.clear();    //与map1 == null操作不同
        System.out.println(map1.size());
        //0
        System.out.println(map1);
        //{}
    }

    /**
     * 元素查询的操作
     * V get(Object key):返回到指定键所映射的值，或 null如果此映射包含该键的映射。
     * boolean containsKey(Object key):如果此映射包含指定键的映射，则返回 true 。
     * boolean containsValue(Object value):如果此Map将一个或多个键映射到指定的值，则返回 true 。
     * int size():返回此地图中键值映射的数量。
     * boolean isEmpty():如果此Map不包含键值映射，则返回 true 。
     * boolean equals(Object o):将指定的对象与此映射进行比较以获得相等性。
     */
    @Test
    public void test2() {
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",456);

        System.out.println(map.get(45));
        //123

        boolean isExist = map.containsKey("BB");
        System.out.println(isExist);
        //true

        isExist = map.containsValue(123);
        System.out.println(isExist);
        //true，只要找到一个true就不会往下找了

        map.clear();
        boolean empty = map.isEmpty();
        System.out.println(empty);
    }

    /**
     * 元视图操作的方法：
     *  Set<K> keySet():返回此Map中包含的键的Set视图。
     *  Set<Map.Entry<K,V>> entrySet():返回此Map中包含的映射的Set视图。
     *  Collection<V> values():返回此地图中包含的值的Collection视图。
     */
    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("AA", 123);
        map.put(45, 1234);
        map.put("BB", 456);

        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
            //AA BB 45
        }
        System.out.println();

        //遍历所有的value集：values()
        Collection values = map.values();
        for (Object obj : values) {
            System.out.print(obj + " ");
            //123 456 1234
        }
        System.out.println();

        //遍历所有的key-value：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
            //AA=123 BB=456 45=1234
        }
    }
}
