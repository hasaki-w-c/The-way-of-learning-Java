package juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList/CopyOnWriteArraySet: : “写入并复制”
 *
 * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销会非常大。
 *      并发迭代操作多时，可以选择，能够提高效率。
 *
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/18 14:02
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {

        HelloThread ht = new HelloThread();

        for (int i = 0; i < 10; i++) {
            new Thread(ht).start();
        }
    }

}

class HelloThread implements Runnable{

    //private static List<String> list = Collections.synchronizedList(new ArrayList<String>());

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static{
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            //ConcurrentModificationException:并发修改异常

            list.add("AA");
        }

    }
}
