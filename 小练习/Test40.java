package com.hasaki.dayexer;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/*
List的一个面试题
区分List中的remove(int index)和remove(Object obj)
 */
public class Test40 {
    @Test
    public void test() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private void updateList(List list) {
        list.remove(2);    //这里删除的是角标2
        //list.remove(Integer.valueOf(2));    //这里我们手动装箱，变成对象，就可以删除元素2了
    }
}
