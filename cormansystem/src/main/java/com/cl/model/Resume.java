package com.cl.model;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by one on 2018/4/20.
 */
public class Resume implements Serializable{//简历
    private int r_id;
    private String r_name;
    private int r_age;
    private String r_origin;//籍贯
    private String r_family;//名族
    private BigInteger r_phone;//电话
    private String r_email;//邮箱
    private String r_address;//地址
    private String r_campus;//教育成都
    private String r_jobs;//工作精力
    private String r_evaluation;
    private User user;

    public Resume() {
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public int getR_age() {
        return r_age;
    }

    public void setR_age(int r_age) {
        this.r_age = r_age;
    }

    public String getR_origin() {
        return r_origin;
    }

    public void setR_origin(String r_origin) {
        this.r_origin = r_origin;
    }

    public String getR_family() {
        return r_family;
    }

    public void setR_family(String r_family) {
        this.r_family = r_family;
    }

    public BigInteger getR_phone() {
        return r_phone;
    }

    public void setR_phone(BigInteger r_phone) {
        this.r_phone = r_phone;
    }

    public String getR_email() {
        return r_email;
    }

    public void setR_email(String r_email) {
        this.r_email = r_email;
    }

    public String getR_address() {
        return r_address;
    }

    public void setR_address(String r_address) {
        this.r_address = r_address;
    }

    public String getR_campus() {
        return r_campus;
    }

    public void setR_campus(String r_campus) {
        this.r_campus = r_campus;
    }

    public String getR_jobs() {
        return r_jobs;
    }

    public void setR_jobs(String r_jobs) {
        this.r_jobs = r_jobs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getR_evaluation() {
        return r_evaluation;
    }

    public void setR_evaluation(String r_evaluation) {
        this.r_evaluation = r_evaluation;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_age=" + r_age +
                ", r_originl='" + r_origin + '\'' +
                ", r_family='" + r_family + '\'' +
                ", r_phone=" + r_phone +
                ", r_email='" + r_email + '\'' +
                ", r_address='" + r_address + '\'' +
                ", r_campus='" + r_campus + '\'' +
                ", r_jobs='" + r_jobs + '\'' +
                '}';
    }
}
