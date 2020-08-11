public class Test19Customer {
    private String firstname;    //名
    private String lastname;    //姓
    private Test19Account accout;    //账户

    public Test19Customer(String f , String l) {
        this.firstname = f;
        this.lastname = l;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Test19Account getAccout() {
        return accout;
    }

    public void setAccout(Test19Account accout) {
        this.accout = accout;
    }
}
