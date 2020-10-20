package jiekou;

/*
希望学生类对象，可以比较大小，遵循对象比较大小的标准。
让学生类实现java.lang.Comparable接口

java.lang.Comparable接口中有一个抽象方法int compareTo(Object o)
 */
public class Student implements Comparable{
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    /*
    假设这里要求学生按照成绩比较大小
    比较两个学生对象：this和o
     */

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Student)) {
            //不能比较大小，应该抛出异常，这里先提示
            System.out.println("o不是学生对象");
            return 0;    //按理说返回0不合适
        }

        Student stu = (Student) o;    //要使用这个排序，就得实现这个强制转换，否则报错
        if (this.score > stu.score) {
            return 1;
        }else if (this.score < stu.score) {
            return -1;
        }
        return 0;
    }
}
