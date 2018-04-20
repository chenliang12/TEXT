package com.cl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by one on 2018/4/20.
 */
public class Wage implements Serializable{
    private int w_id;
    private int bawage;//基本工资
    private int performance;//绩效工资
    private int overrtime;//加班工资
    private int social;//社保
    private int reandpun_id;//奖惩工资
    private User user;
    private int date;//时间

    public Wage() {
    }


    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public int getBawage() {
        return bawage;
    }

    public void setBawage(int bawage) {
        this.bawage = bawage;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getOverrtime() {
        return overrtime;
    }

    public void setOverrtime(int overrtime) {
        this.overrtime = overrtime;
    }

    public int getSocial() {
        return social;
    }

    public void setSocial(int social) {
        this.social = social;
    }


    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Wage{" +
                "w_id=" + w_id +
                ", bawage=" + bawage +
                ", performance=" + performance +
                ", overrtime=" + overrtime +
                ", social=" + social +
                ", date=" + date +
                '}';
    }
}
