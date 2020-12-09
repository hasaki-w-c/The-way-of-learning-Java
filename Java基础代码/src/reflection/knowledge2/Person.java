package reflection.knowledge2;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/5 16:52
 */
@MyAnnotation(value = "hi")
public class Person extends Creatuer<String> implements Comparable<String>,MyInterface{

    private String name;
    int age;
    public int id;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public Person() {
    }

    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests) {
        return interests;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    public static void showDesc() {
        System.out.println("我是一个可爱的人");
    }
}
