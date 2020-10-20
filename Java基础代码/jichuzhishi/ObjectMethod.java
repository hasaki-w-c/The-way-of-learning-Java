package jichuzhishi;

import java.util.Objects;
import java.util.Scanner;

/*
Object的方法：
 1.Class getClass()    :返回此Object的运行时类。
 Class:类型
 2.String toString()    :建议所有子类都重写这个方法
  记住：①当你打印一个对象时，默认调用这个对象的toString()
       ②当一个对象与String的值进行“+”拼接操作时，也会调用这个对象的toString()
 3.双胞胎：int hashCode() 和 boolean equals(Object obj)
   int hashCode():返回对象的哈希码值。
   boolean equals(Object obj)：指示其他某个对象是否与此对象“相等”。
       ①如果一个类没有重写Object的equals方法，那么效果和“==”是一样的，比较的是两个对象的地址。
       ②如果这个类，不想用equals比较地址，而是比较属性的内容，那么需要“重写”这个方法。
 4.protected void finalize()：当垃圾收集确定不再有对该对象的引用时，垃圾收集器在对象上调用该对象
   比喻为：对象回收前，留临终遗言的方法。
   实际中
  面试题：finalize、final、finally的区别
 */
public class ObjectMethod {
    public static void main(String[] args) {
        Object obj = "Hello";
        System.out.println(obj.getClass());    //obj这个对象的运行时类型：class java.lang.String

        ObjectMethod t = new ObjectMethod();    //jichuzhishi.ObjectMethod@10f87f48
        //类名@10f87f48(数字为对象的哈希码的无符号的十六进制)
        System.out.println(t);
        System.out.println(t.hashCode());    //哈希码十进制：284720968

        String str = "对象的信息";
        str = str + t;
        str = str + t.toString();
        System.out.println(str);

        Student stu = new Student("王琛",20,100);
        System.out.println(stu);

        String str1 = "BB";
        String str2 = "Aa";
        //不同的对象,其哈希码又可能相同
        System.out.println(str1.hashCode());    //2112
        System.out.println(str2.hashCode());    //2112

        Student stu1 = new Student("张三",23,89);
        Student stu2 = new Student("张三",23,89);
        System.out.println(stu1.equals(stu2));
        System.out.println(stu1 == stu2);    //比较的是两个对象的地址

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入是否愿意:");
        String input = sc.next();

        if ("愿意".equals(input)) {
            System.out.println("恭喜！");
        }else {
            System.out.println("放屁！");
        }
    }
}

class Student {
    private String name;
    private int age;
    private int score;

    public Student() {
    }

    public Student(String name , int age , int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }
}
