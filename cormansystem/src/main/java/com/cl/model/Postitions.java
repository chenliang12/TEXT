package com.cl.model;

import java.io.Serializable;

/**
 * Created by one on 2018/4/20.
 */
public class Postitions implements Serializable{//职位
    private int p_id;
    private String p_position;
    private User user;
    private Department department;
    public Postitions() {
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_position() {
        return p_position;
    }

    public void setP_position(String p_position) {
        this.p_position = p_position;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Postitions{" +
                "p_id=" + p_id +
                ", position='" + p_position + '\'' +
                '}';
    }
}
