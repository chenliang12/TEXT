package com.cl.model;

import java.io.Serializable;

/**
 * Created by one on 2018/4/20.
 */
public class Resume implements Serializable{//简历
    private int r_id;
    private String name;
    private int age;
    private String originl;//籍贯
    private String family;//名族
    private int phone;//电话
    private String email;//邮箱
    private String address;//地址
    private String campus;//教育成都
    private String jobs;//工作精力
    private String state;//简历状态
    private User user;

    public Resume() {
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOriginl() {
        return originl;
    }

    public void setOriginl(String originl) {
        this.originl = originl;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "r_id=" + r_id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", originl='" + originl + '\'' +
                ", family='" + family + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", campus='" + campus + '\'' +
                ", jobs='" + jobs + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
