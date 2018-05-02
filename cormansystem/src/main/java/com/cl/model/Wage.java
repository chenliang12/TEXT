package com.cl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by one on 2018/4/20.
 */
public class Wage implements Serializable{
    private int w_id;
    private int w_bawage;//基本工资
    private int w_performance;//绩效工资
    private double w_social;//社保
    private int w_reandpun;//奖惩工资
    private double w_wages;
    private Employee employee;
    private int w_year;//时间
    private int w_month;
    public Wage() {
    }

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public int getW_bawage() {
        return w_bawage;
    }

    public void setW_bawage(int w_bawage) {
        this.w_bawage = w_bawage;
    }

    public int getW_performance() {
        return w_performance;
    }

    public void setW_performance(int w_performance) {
        this.w_performance = w_performance;
    }

    public double getW_social() {
        return w_social;
    }

    public void setW_social(double w_social) {
        this.w_social = w_social;
    }

    public double getW_wages() {
        return w_wages;
    }

    public void setW_wages(double w_wages) {
        this.w_wages = w_wages;
    }

    public int getW_reandpun() {
        return w_reandpun;
    }

    public void setW_reandpun(int w_reandpun) {
        this.w_reandpun = w_reandpun;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getW_year() {
        return w_year;
    }

    public void setW_year(int w_year) {
        this.w_year = w_year;
    }

    public int getW_month() {
        return w_month;
    }

    public void setW_month(int w_month) {
        this.w_month = w_month;
    }

    @Override
    public String toString() {
        return "Wage{" +
                "w_id=" + w_id +
                ", w_bawage=" + w_bawage +
                ", w_performance=" + w_performance +
                ", w_social=" + w_social +
                ", w_reandpun=" + w_reandpun +
                ", w_wages=" + w_wages +
                ", w_year=" + w_year +
                ", w_month=" + w_month +
                '}';
    }
}
