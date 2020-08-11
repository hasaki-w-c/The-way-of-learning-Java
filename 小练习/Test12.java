/*
题目：定义类Test12stu,包含三个属性：学号：num，年级：state，分数：score。
创建20个学生对象，学号为1到20，年级和成绩都由随机数确定，打印出三年级（state为3）的学生的信息。

提示：
生成随机数：Math.random(),返回值类型double。
四舍五入取整：Math.round(double d)，返回值类型long。
 */

import java.util.Arrays;

public class Test12 {
    public static void main(String[] args) {
        Test12stu[] stu = new Test12stu[20];
        for (int i = 0; i < stu.length; i ++){
            stu[i] = new Test12stu();
            stu[i].num = i + 1;
            stu[i].state = (int)(Math.random() * 9 + 1);
            stu[i].score = Math.round((Math.random() * 100));

            if (stu[i].state == 3){
                System.out.println("学号:" + stu[i].num + "\t" + "年级:" + stu[i].state + "\t" + "成绩:" + stu[i].score);
            }
        }
    }
}
