package chazhao;

import java.util.Arrays;

/*
二分法查找
前提：数组有序

随机数方法
这里会用到一个获取随机数的方法:Math.random() : [0.0,1.0)

要得到题目要求，则需要进行一系列改变
Math.random() * 90 :[0.0,90.0)
(int)(Math.random() * 90) : [0,89]
(int)(Math.random() * 90 + 10) ： [10,99]

所以就得出一个公式：
获取[a,b]内的随机数：(int)(Math.random() * (b - a + 1) + a)
 */
public class Erfen {
    public static void main(String[] args){
        int[] a = new int[10];

        //对数组赋值(此处我进行了随机赋值)
        for (int i = 0; i < a.length; i ++){
            a[i] = (int)(Math.random() * 100);    //[0,99]
        }

        //查看数组元素
        System.out.println("数组元素为：" + Arrays.toString(a));

        //排序一下
        for (int i = 0;i < a.length; i ++)
        {
            for (int j = 0;j < a.length - i - 1; j ++)
            {
                int t;
                if (a[j] < a[j+1])
                {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }

        //输出排序好的数组
        System.out.println("数组元素为：" + Arrays.toString(a));

        int velue = 99;    //需要查找的数
        int head = 0;    //首索引
        int end = a.length - 1;    //尾索引
        boolean flag = true;

        //进行查找（在排序好的基础上）
        while (head <= end){
            int mid = (head + end) / 2;

            if ((a[mid] == velue)){
                System.out.println("找到数据，索引位置为" + mid);
                flag = false;
                break;
            }
            else if (a[mid] < velue){
                end = mid - 1;
            }
            else {//(a[mid] > velue
                head = mid + 1;
            }
        }
        if (flag){
            System.out.println("没找到有这个元素哦！");
        }
    }
}
