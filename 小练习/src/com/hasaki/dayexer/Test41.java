package com.hasaki.dayexer;

import java.util.*;

/**
 * 定义个泛型类Test41<T></>,在其中定义一个Map成员变量，Map的键为String类型，值为T类型。
 *
 * 反别创建以下方法;
 *
 * public void save(String id, T entity):保存T类型的对象到Map成员变量中
 * public T get(String id):从map中获取id对应的对象
 * public void update(String id, T entity):替换map中key为id的内容，改为entity对象
 * public List<T></> list():返回map中存放的所有T对象
 * public void delete(String id):删除指定的id对象
 *
 * @author hasaki
 */

public class Test41<T> {

    /**
     * private Map<String, T> map：这样写容易出现空指针异常，一般直接后边进行实例化
     */
    private Map<String, T> map = new HashMap<>();

    /**
     * 保存T类型的对象到Map成员变量中
     * @param id : 输入的键
     * @param entity : 输入的值
     */
    public void save(String id, T entity) {
        map.put(id, entity);
    }

    /**
     * 从map中获取id对应的对象
     * @param id : 想要获取的对象的键
     * @return : 返回所需要获取的对象
     */
    public T get(String id) {
        return map.get(id);
    }

    /**
     * 替换map中key为id的内容，改为entity对象
     * @param id : 想要修改的键
     * @param entity ：要改的值
     */
    public void update(String id, T entity) {
        if (map.containsKey(id)) {
            map.put(id, entity);
        }else {
            System.out.println("不存在该ID，请添加后再修i该");
        }
    }

    /**
     * 返回map中存放的所有T对象
     * @return T对象
     */
    public List<T> list() {
        //错误的写法：
        //Collection<T> values = map.values();
        // return (List<T>) values;
        // 正确的写法
        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();
        for (T t : values) {
            list.add(t);
        }
        return list;
    }

    /**
     * 删除指定的id对象
     * @param id : 所要删除的键值对
     */
    public void delete(String id) {
        map.remove(id);
    }
}

/**
 * 定义一个User类：
 * 该类包含：private成员变量（int类型） id，age； （String类型）name。
 */
class User {
    private int id;
    private int age;
    private String name;

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                name == user.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }
}

/**
 * 创建Test41类的对象，分别调用其save、get、update、list、delete方法来操作User对象
 */
class Test41Test {
    public static void main(String[] args) {
        Test41<User> u1 = new Test41<>();

        u1.save("1001",new User(001,33,"张三"));
        u1.save("1002",new User(002,44,"李四"));
        u1.save("1003",new User(003,20,"王琛"));

        u1.update("1003",new User(003,55,"王五"));

        u1.delete("1003");

        List<User> list = u1.list();
        list.forEach(System.out::println);
        //可替换System.out.println(list);
    }
}