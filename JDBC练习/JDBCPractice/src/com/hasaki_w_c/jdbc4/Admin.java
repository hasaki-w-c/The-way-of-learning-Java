package com.hasaki_w_c.jdbc4;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/14 16:57
 */
public class Admin {
    private Integer id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    /**
     * new BeanHandler<>(Admin.class)使用这个类时
     * 必须由这个无参构造器，因为底层是用反射去创造对象，再通过属性去设置，这也是为什么属性名和字段名要一致
     */
    public Admin() {
    }

    public Admin(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
