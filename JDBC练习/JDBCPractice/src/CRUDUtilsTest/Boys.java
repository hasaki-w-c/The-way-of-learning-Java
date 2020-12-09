package CRUDUtilsTest;

/**
 * @author hasaki_w_c
 * @version 1.0
 * @date 2020/11/14 15:34
 */
public class Boys {
    public Integer id;
    public String boyName;
    private Integer userCP;

    @Override
    public String toString() {
        return "Boys{" +
                "id=" + id +
                ", boyName='" + boyName + '\'' +
                ", userCP=" + userCP +
                '}';
    }

    public Boys() {
    }

    public Boys(Integer id, String boyName, Integer userCP) {
        this.id = id;
        this.boyName = boyName;
        this.userCP = userCP;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBoyName() {
        return boyName;
    }

    public void setBoyName(String boyName) {
        this.boyName = boyName;
    }

    public Integer getUserCP() {
        return userCP;
    }

    public void setUserCP(Integer userCP) {
        this.userCP = userCP;
    }
}
