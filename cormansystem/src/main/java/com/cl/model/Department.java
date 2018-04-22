package com.cl.model;

/**
 * Created by one on 2018/4/22.
 */
public class Department {//部门
    private int d_id;
    private String d_depat;

    public Department() {
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_depat() {
        return d_depat;
    }

    public void setD_depat(String d_depat) {
        this.d_depat = d_depat;
    }

    @Override
    public String toString() {
        return "Department{" +
                "d_id=" + d_id +
                ", d_depat='" + d_depat + '\'' +
                '}';
    }
}
