/*
打印如下图
*
***
*****
*******
*********
 */

public class Test01 {
    public static void main(String[] args) {
        for (int h = 1; h < 6; h ++)
        {
            for (int i = 1; i <= 2 * h - 1; i ++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
