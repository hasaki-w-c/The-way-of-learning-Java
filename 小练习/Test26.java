package com.hasaki.dayexer;

/*
要求：
  将一个字符串进行反转。将字符串中指定部分进行反转。比如将"abcdefgho"反转为"abfedcgho"
 */
public class Test26 {
    public static void main(String[] args) {
        String str1 = "abcdefgho";
        String str2 = "abcdefgho";
        str1 = reverse1(str1, 2, 5);
        str2 = reverse2(str2, 2, 5);
        System.out.println(str1);
        System.out.println(str2);
    }

    /*方法一
    把str分为三个部分
    左，中，右三个部分
    反转中间部分
    拼接
     */
    public static String reverse1(String str1, int start, int end) {
        String left = str1.substring(0, start);
        String right = str1.substring(end + 1);
        String mid = str1.substring(start, end + 1);

        char[] charArray = mid.toCharArray();    //中间的数组，首尾对应位置交换
        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length-1-i];
            charArray[charArray.length-1-i] = temp;
        }
        mid = new String(charArray);
        return left + mid + right;
    }
    /*
    方法二
     直接把str转为数组
     直接交换[start,end]
     */
    public static String reverse2(String str2, int start, int end) {
        char[] charArray = str2.toCharArray();    //中间的数组，首尾对应位置交换
        for (int i = start, j = end; i < j; i++,j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }
}
