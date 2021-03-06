package com.bjsxt.pojo;

import java.util.Date;

public class Log {
    private int id;
    private String accout;
    private String accin;
    private double money;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccout() {
        return accout;
    }

    public void setAccout(String accout) {
        this.accout = accout;
    }

    public String getAccin() {
        return accin;
    }

    public void setAccin(String accin) {
        this.accin = accin;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"accout\":\"")
                .append(accout).append('\"');
        sb.append(",\"accin\":\"")
                .append(accin).append('\"');
        sb.append(",\"money\":")
                .append(money);
        sb.append(",\"date\":\"")
                .append(date).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
