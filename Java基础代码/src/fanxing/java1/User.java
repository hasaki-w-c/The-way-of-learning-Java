package fanxing.java1;

import java.util.Objects;


/**
 * @author Lenovo
 */
public class User implements Comparable<User>{
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 首先按照姓名从小到大排列，其次年龄从小到大排列
     */
    //未使用泛型的操作
    //@Override
    //public int compareTo(Object o) {
    //    if (o instanceof User) {
    //        User user = (User) o;
    //        //return this.name.compareTo(user.name);
    //        //return -this.name.compareTo(user.name)从大到小排列
    //        int compare = this.name.compareTo(user.name);
    //        if (compare != 0) {
    //            return compare;
    //        }else {
    //            return Integer.compare(this.age,user.age);
    //        }
    //    }else {
    //        throw new RuntimeException("输入的类型不匹配");
    //    }
    //}

    /**
     * 使用泛型的操作
     * @param o:要比较的对象
     * @return 负整数，零或正整数，因为该对象小于，等于或大于指定对象。
     */
    @Override
    public int compareTo(User o) {
        return this.name.compareTo(o.name);
    }
}
