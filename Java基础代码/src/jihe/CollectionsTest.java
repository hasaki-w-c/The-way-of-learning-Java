package jihe;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections：操作Collection、Map的工具类
 *
 * Collections和Collection的区别？
 *
 * @author hasaki
 */

public class CollectionsTest {
    /**
    reverse(List)：反转List中元素的顺序
    shuffle(List)：对List集合元素进行随机排序
    sort(List)：根据元素的自然顺序对 指定List集合元素按升序排序
    sort(List, Comparator)：根据指定的Comparator产生的顺序对List集合元素进行排序
    swap(List, int, int)：将指定Lis集合中i处的元素和j处的元素进交换

    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection, Comparator)：根据Comparator指定的顺序，返回给定集合中的最大元素
    Object min(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object min(Collection, Comparator)：根据Comparator指定的顺序，返回给定集合中的最小元素
    int frequency(Collection, Object)：返回指定集合中指定元素的出现次数
    void copy(List dest, List src)：将sr中的内容复制到dest中
    boolean replaceAll(List list, Object oldVal, Object newVal)：使用新值替换List对象
     */
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(528);
        list.add(-321);
        list.add(0);

        System.out.println(list);
        //[123, 456, 528, -321, 0]

        //Collections.reverse(list);//[0, -321, 528, 456, 123]
        //
        //Collections.shuffle(list);//随机的排列
        //
        //Collections.sort(list);//[-321, 0, 123, 456, 528]
        //
        //Collections.swap(list,1,2);//[123, 528, 456, -321, 0]
        //
        //int frequency = Collections.frequency(list,0);//表示0在list里出现过几次
        //System.out.println(frequency + "次");//0次
        System.out.println(list);
    }

    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(528);
        list.add(-321);
        list.add(0);

        //错误写法：dest长度小于list就会报异常
        //List dest = new ArrayList();
        //Collections.copy(dest,list);

        //正确的
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);

        System.out.println(dest);
    }

    /**
     *Collections类中提供了多个synchronizedXxx()方法，该方法可使将指定集合包装成线程同步的集合，
     * 从而解决多线程并发访问集合时的线程安全问题
     */
    @Test
    public void test3() {
        List list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(528);
        list.add(-321);
        list.add(0);

        //返回的list1即为线程安全的List
        List list1 = Collections.synchronizedList(list);
    }
}
