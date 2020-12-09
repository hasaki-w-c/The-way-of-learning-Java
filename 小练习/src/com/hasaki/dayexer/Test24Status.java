package com.hasaki.dayexer;

public enum Test24Status {
    BUSY("空闲"),FREE("忙碌"),VOCATION("休假"),LEFT("离职");    //常量对象一般大写

    private String desc;

    Test24Status(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "com.hasaki.dayexer.Test24Status{" +
                "desc='" + desc + '\'' +
                '}';
    }
}
