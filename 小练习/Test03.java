/*
求100以内的素数，将结果和个数都打印出来
 */

public class Test03 {
    public static void main(String[] args)
    {
        int num = 0;
        boolean flag = true;
        for (int i = 2; i < 101; i ++)
        {
            for (int j = 2; j < i; j ++)
            {
                if (i % j == 0)
                {
                    flag = false;
                }
            }
            if (flag == true)
            {
                System.out.print(i + ",");
                num = num + 1;
            }
            flag = true;
        }
        System.out.println("总共有" + num + "个质数");
    }
}
