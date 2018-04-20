package com.cl.model;

import java.io.Serializable;

/**
 * Created by one on 2018/4/20.
 */
public class User implements Serializable{
    private int u_id;
    private String uname;
    private String upass;
    private String authority;

    public User() {
    }

    public User(int u_id, String uname, String upass, String authority) {
        this.u_id = u_id;
        this.uname = uname;
        this.upass = upass;
        this.authority = authority;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
