/*
定义一个int型的数组：int[] arr = new int[]{12,3,3,34,56,77,432};
让数组的每个位置上的值去除以首位置的元素，得到的结果，作为该位置上的新值。遍历新的数组。
 */

import java.util.Arrays;

public class Test15 {
    public static void main(String[] args) {
        int[] arr = new int[]{12,3,3,34,56,77,432};
        
        /*错误写法
        for (int i = 0; i < arr.length; i ++){
            arr[i] = arr[i] / arr[0];
        }
         */

        /*正确写法一
        for (int i = arr.length - 1; i >= 0; i --){
            arr[i] = arr[i] / arr[0];
        }
         */

        //正确写法二
        int temp = arr[0];
        for (int i = 0; i < arr.length; i ++){
            arr[i] = arr[i] / temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
