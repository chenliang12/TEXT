package com.cl.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by one on 2018/4/22.
 */
public class Employee implements Serializable{//员工信息
    private int e_id;
    private String e_name;
    private int e_age;
    private String e_origin;//籍贯
    private String e_sex;
    private User user;
    private BigInteger e_phone;
    private Date e_createtime;//入职时间
    private String e_state;//状态
    private String e_reason;//离职原因

    public Employee() {
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public int getE_age() {
        return e_age;
    }

    public void setE_age(int e_age) {
        this.e_age = e_age;
    }

    public String getE_origin() {
        return e_origin;
    }

    public void setE_origin(String e_origin) {
        this.e_origin = e_origin;
    }

    public String getE_sex() {
        return e_sex;
    }

    public void setE_sex(String e_sex) {
        this.e_sex = e_sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigInteger getE_phone() {
        return e_phone;
    }

    public void setE_phone(BigInteger e_phone) {
        this.e_phone = e_phone;
    }

    public Date getE_createtime() {
        return e_createtime;
    }

    public void setE_createtime(Date e_createtime) {
        this.e_createtime = e_createtime;
    }

    public String getE_state() {
        return e_state;
    }

    public void setE_state(String e_state) {
        this.e_state = e_state;
    }

    public String getE_reason() {
        return e_reason;
    }

    public void setE_reason(String e_reason) {
        this.e_reason = e_reason;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_age=" + e_age +
                ", e_origin='" + e_origin + '\'' +
                ", e_sex='" + e_sex + '\'' +
                ", user=" + user +
                ", e_phone=" + e_phone +
                ", e_createtime=" + e_createtime +
                ", e_state='" + e_state + '\'' +
                ", e_reason='" + e_reason + '\'' +
                '}';
    }
}
