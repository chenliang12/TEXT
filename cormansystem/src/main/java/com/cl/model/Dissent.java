package com.cl.model;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.io.Serializable;

/**
 * Created by one on 2018/4/22.
 */
public class Dissent implements Serializable {//工资异议
    private int d_id;
    private String d_reason;//原因
    private User user;
    private Wage wage;
    private String d_state;

    public Dissent() {
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_reason() {
        return d_reason;
    }

    public void setD_reason(String d_reason) {
        this.d_reason = d_reason;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Wage getWage() {
        return wage;
    }

    public void setWage(Wage wage) {
        this.wage = wage;
    }

    public String getD_state() {
        return d_state;
    }

    public void setD_state(String d_state) {
        this.d_state = d_state;
    }

    @Override
    public String toString() {
        return "Dissent{" +
                "d_id=" + d_id +
                ", d_reason='" + d_reason + '\'' +
                ", d_state='" + d_state + '\'' +
                '}';
    }
}
