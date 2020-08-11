package paixu;

/*
 * 此程序为冒泡排序，对学生的成绩，学号，和姓名进行排序，以成绩为排序，输出其对应信息。
 */
import java.util.Scanner;

public class Maopaodemo {

    public static void main(String[] args) {
        MaopaoStu[] a = new MaopaoStu[100];    //创建类数组对象。限制学生个数。
        int i, j;
        MaopaoStu t;
        System.out.println("请输入有多少个数要进行排序：");
        Scanner ge = new Scanner(System.in);
        int n = ge.nextInt();    //输入有多少个学生n

        System.out.println("请输入学生的相关信息，按照学号、姓名、分数进行输入：");
        System.out.println("注意：输入每个信息都需要换行！");
        for (i = 1;i <= n;i ++)    //循环输入学生的学号，姓名和分数。
        {
            a[i] = new MaopaoStu();    //数组中的每个元素都是一个对象，既然是对象我们就得对他进行分配空间（new）。
            Scanner in = new Scanner(System.in);
            a[i].num = in.next();
            a[i].name = in.next();
            a[i].score = in.nextInt();
        }

        System.out.println("输出排好序的学生信息：");
        for (i =1;i <= n-1;i ++)    //按分数从高到底进行排序
        {
            for (j = 1;j <= n - i;j ++)
            {
                if (a[j].score < a[j + 1].score)    //比较分数
                {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }

        for (i = 1;i <= n;i ++)    //输出根据分数排序好的学生信息
        {
            System.out.println("排名第" + i + "位的是" + a[i].num + " " + a[i].name + " " + a[i].score);
        }
    }

}
