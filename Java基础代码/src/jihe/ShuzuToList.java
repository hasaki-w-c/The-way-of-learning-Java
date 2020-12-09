package jihe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 数组转为List。
 * @author Lenovo
 */
public class ShuzuToList {
    @Test
    /**
     * 通过 Arrays.asList(strArray) 方式,将数组转换List后，不能对List增删，只能查改，否则抛异常。
     *
     * 使用场景：Arrays.asList(strArray)方式仅能用在将数组转换为List后，
     * 不需要增删其中的值，仅作为数据源读取使用。
     */
    public void test1() {
        String[] strArray = new String[2];
        /*
        原因解析：Arrays.asList(strArray)返回值是java.util.Arrays类中一个私有静态内部类java.util.Arrays.
        ArrayList，它并非java.util.ArrayList类。java.util.Arrays.ArrayList类具有
         set()，get()，contains()等方法，但是不具有添加add()或删除remove()方法,所以调用add()方法会报错。
         */
        List list = Arrays.asList(strArray);
        //对转换后的list插入一个值
        //会有异常：UnsupportedOperationException
        list.add(1);
        System.out.println(list);
    }

    @Test
    /**
     * 通过ArrayList的构造器，将Arrays.asList(strArray)的返回值由java.util.Arrays.ArrayList
     * 转为java.util.ArrayList。
     *
     * 使用场景：需要在将数组转换为List后，对List进行增删改查操作，在List的数据量不大的情况下，可以使用。
     */
    public void test2() {
        String[] strArray = new String[2];
        ArrayList<String > list = new ArrayList<String >(Arrays.asList(strArray));
        list.add("1");
        //[null, null, 1]
        System.out.println(list);
    }

    @Test
    /**
     * 通过Collections.addAll(arrayList, strArray)方式转换，根据数组的长度创建一个长度相同的List，
     * 然后通过Collections.addAll()方法，将数组中的元素转为二进制，然后添加到List中，这是最高效的方法。
     *
     * 使用场景：需要在将数组转换为List后，对List进行增删改查操作，在List的数据量巨大的情况下，优先使用，可以提高操作速度。
     */
    public void test3() {
        String[] strArray = new String[2];
        ArrayList< String> arrayList = new ArrayList<String>(strArray.length);
        Collections.addAll(arrayList, strArray);
        arrayList.add("1");
        //[null, null, 1]
        System.out.println(arrayList);
    }
}
