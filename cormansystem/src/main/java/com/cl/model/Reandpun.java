package com.cl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by one on 2018/4/20.
 */
public class Reandpun implements Serializable {//奖惩
    private int re_id;
    private int re_reward;//奖励金额
    private int re_punishment;//惩罚金额
    private String re_explanation;//原因
    private Employee employee;
    private Date re_date;
    private String re_state;
    private int re_year;
    private int re_month;
    private String date;

    public Reandpun() {
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public int getRe_reward() {
        return re_reward;
    }

    public void setRe_reward(int re_reward) {
        this.re_reward = re_reward;
    }

    public int getRe_punishment() {
        return re_punishment;
    }

    public void setRe_punishment(int re_punishment) {
        this.re_punishment = re_punishment;
    }

    public String getRe_explanation() {
        return re_explanation;
    }

    public void setRe_explanation(String re_explanation) {
        this.re_explanation = re_explanation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getRe_date() {
        return re_date;
    }

    public void setRe_date(Date re_date) {
        this.re_date = re_date;
    }

    public String getRe_state() {
        return re_state;
    }

    public void setRe_state(String re_state) {
        this.re_state = re_state;
    }

    public int getRe_year() {
        return re_year;
    }

    public void setRe_year(int re_year) {
        this.re_year = re_year;
    }

    public int getRe_month() {
        return re_month;
    }

    public void setRe_month(int re_month) {
        this.re_month = re_month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reandpun{" +
                "re_id=" + re_id +
                ", re_reward=" + re_reward +
                ", re_punishment=" + re_punishment +
                ", re_explanation='" + re_explanation + '\'' +
                ", re_date=" + re_date +
                ", re_state='" + re_state + '\'' +
                ", re_year=" + re_year +
                ", re_month=" + re_month +
                '}';
    }
}
