package lei;

public class Account {

    //账号
    private String actno;

    //余额
    private double balance;

    //无参数构造器
    public Account() {
        //初始化实例变量的内存空间
        //actno = null;    系统默认赋值
        //balance = 0.0;    系统默认赋值
    }

    public Account(String s)
    {
        actno = s;
    }

    public Account(double d)
    {
        balance = d;
    }

    public Account(String s , double d)
    {
        actno = s;
        balance = d;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
