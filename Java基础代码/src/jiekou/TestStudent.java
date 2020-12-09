package jiekou;

public class TestStudent {
    public static void main(String[] args) {
        jiekou.Student stu1 = new jiekou.Student("张三", 89);
        jiekou.Student stu2 = new jiekou.Student("李四", 95);

        System.out.println(stu1.compareTo(stu2));
        if (stu1.compareTo(stu2) == 0) {
            System.out.println("stu1等于stu2");
        }else if (stu1.compareTo(stu2) > 0) {
            System.out.println("stu1大于stu2");
        }else {
            System.out.println("stu1小于stu2");
        }
    }
}
