package com.cl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by one on 2018/4/20.
 */
public class Train implements Serializable{//培训
    private int t_id;
    private String t_title;//培训主题
    private String t_content;//培训内容
    private String t_address;//培训地点
    private String t_date;//培训时间
    private Department department;
    private String t_state;
    public Train() {
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_title() {
        return t_title;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public String getT_content() {
        return t_content;
    }

    public void setT_content(String t_content) {
        this.t_content = t_content;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public String getT_date() {
        return t_date;
    }

    public void setT_date(String t_date) {
        this.t_date = t_date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getT_state() {
        return t_state;
    }

    public void setT_state(String t_state) {
        this.t_state = t_state;
    }

    @Override
    public String toString() {
        return "Train{" +
                "t_id=" + t_id +
                ", t_title='" + t_title + '\'' +
                ", t_content='" + t_content + '\'' +
                ", t_address='" + t_address + '\'' +
                ", t_date='" + t_date + '\'' +
                ", department=" + department +
                ", t_state='" + t_state + '\'' +
                '}';
    }
}
