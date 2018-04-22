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
    private int w_overrtime;//加班工资
    private int w_social;//社保
    private int w_reandpun_id;//奖惩工资
    private User user;
    private int w_date;//时间

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

    public int getW_overrtime() {
        return w_overrtime;
    }

    public void setW_overrtime(int w_overrtime) {
        this.w_overrtime = w_overrtime;
    }

    public int getW_social() {
        return w_social;
    }

    public void setW_social(int w_social) {
        this.w_social = w_social;
    }

    public int getW_reandpun_id() {
        return w_reandpun_id;
    }

    public void setW_reandpun_id(int w_reandpun_id) {
        this.w_reandpun_id = w_reandpun_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getW_date() {
        return w_date;
    }

    public void setW_date(int w_date) {
        this.w_date = w_date;
    }

    @Override
    public String toString() {
        return "Wage{" +
                "w_id=" + w_id +
                ", w_bawage=" + w_bawage +
                ", w_performance=" + w_performance +
                ", w_overrtime=" + w_overrtime +
                ", w_social=" + w_social +
                ", w_reandpun_id=" + w_reandpun_id +
                ", user=" + user +
                ", w_date=" + w_date +
                '}';
    }
}
