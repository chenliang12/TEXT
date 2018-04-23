package com.cl.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by one on 2018/4/22.
 */
public class Department {//部门
    private int d_id;
    private String d_depat;
    private Set<Postitions> postitions=new HashSet<>();

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

    public Set<Postitions> getPostitions() {
        return postitions;
    }

    public void setPostitions(Set<Postitions> postitions) {
        this.postitions = postitions;
    }

    @Override
    public String toString() {
        return "Department{" +
                "d_id=" + d_id +
                ", d_depat='" + d_depat + '\'' +
                '}';
    }
}
