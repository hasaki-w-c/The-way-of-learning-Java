package jichuzhishi;

import java.util.*;
public class ShuzuArray {

    public static void main(String[] args){
        //声明数组
        String [] arr;
        int arr1[];

        //初始化数组
        int arr2[]=new int[]{1,2,3,4,5};
        String[] array1={"马超","马云","关羽","刘备","张飞"};
        String[] array2=new String[]{"黄渤","张艺兴","孙红雷","小猪","牙哥","黄磊"};
        String[] array=new String[5];

        //查看数组的长度
        int length=array1.length;
        System.out.println("length：  "+array1.length);

        //输出数组
        System.out.println(array1);     //结果：[Ljava.lang.String;@32f22097
        System.out.println("arr2:  "+Arrays.toString(arr2));

        //遍历数组
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }

        //int数组转成string数组
        int[]  array3={1,2,3,4,5,6,7,8,9,0};
        String arrStrings=Arrays.toString(array3);
        System.out.println("arrStrings:"+arrStrings);

        //从array中创建arraylist
        ArrayList <String> arrayList=new ArrayList<String>(Arrays.asList(array1));
        System.out.println("arrayList:"+arrayList);

        //数组中是否包含某一个值
        String a="马超";
        if (Arrays.asList(array1).contains(a)) {
            System.out.println("马超在这里");
        }

        //将数组转成set集合
        Set<String> set=new HashSet<String>(Arrays.asList(array2));
        System.out.println("set:"+set);

        //将数组转成list集合
        List<String> list_1=new ArrayList<String>();
        for (int i = 0; i < array2.length; i++) {
            list_1.add(array2[i]);
        }
        System.out.println("list_1:"+list_1);

        String[] arrStrings2={"1","2","3"};
        List<String > list2=Arrays.asList(arrStrings2);
        System.out.println("list2:"+list2);


        //Arrays.fill()填充数组
        int[] arr3=new int[5];
        Arrays.fill(arr3, 10);  //将数组全部填充10
        System.out.println("arr3:"+arr3);
        for (int i = 0; i < arr3.length; i++) {
            System.out.println("arr3[i]:"+arr3[i]);
        }

        //数组排序
        int[] arr4 = {3, 7, 2, 1, 9};
        Arrays.sort(arr4);
        System.out.println("arr4:"+arr4);
        for (int i = 0; i < arr4.length; i++) {
            System.out.println("arr4[i]:"+arr4[i]);
        }

        int[] arr5 = {3, 7, 2, 1, 9,3,45,7,8,8,3,2,65,34,5};
        Arrays.sort(arr5, 1, 4);  //从第几个到第几个之间的进行排序
        for (int i = 0; i < arr5.length; i++) {
            System.out.println("arr5[i]:"+arr5[i]);
        }


        //复制数组
        int[] arr6 = {3, 7, 2, 1};
        int[] arr7=Arrays.copyOf(arr6, 10);  //指定新数组的长度

        int[] arr8=Arrays.copyOfRange(arr6, 1, 3); //只复制从索引[1]到索引[3]之间的元素（不包括索引[3]的元素）
        for (int i = 0; i < arr8.length; i++) {
            System.out.println(arr8[i]);
        }

        //比较两个数组
        int[] arr9 = {1, 2, 3, 4,5,6,7,8,9,0};
        boolean arr10=Arrays.equals(arr6, arr9);
        System.out.println(arr10);

        //去重复
        //利用set的特性
        int[] arr11 = {1, 2, 3, 4,5,6,7,8,9,0,3,2,4,5,6,7,4,32,2,1,1,4,6,3};
        Set<Integer> set2=new HashSet<Integer>();
        for (int i = 0; i < arr11.length; i++) {
            set2.add(arr11[i]);
        }
        System.out.println(set2);
        int[] arr12 = new int[set2.size()];
        int j=0;
        for (Integer i:set2) {
            arr12[j++]=i;
        }
        System.out.println(Arrays.toString(arr12));
    }
}

