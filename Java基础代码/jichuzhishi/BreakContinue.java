package jichuzhishi;
/*
break和continue的用法
break结束当前循环结构
continue结束当此循环结构
这两带标签时，就会显式的结束指定的循环（带标签的循环）
 */
public class BreakContinue {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            if (i % 3 == 0) {
                //break;    //12
                continue;   //124578
            }
            System.out.print(i);
        }
    }
}
