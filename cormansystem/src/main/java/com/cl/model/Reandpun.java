package com.cl.model;

import java.io.Serializable;

/**
 * Created by one on 2018/4/20.
 */
public class Reandpun implements Serializable {//奖惩
    private int re_id;
    private int re_reward;//奖励金额
    private int re_punishment;//惩罚金额
    private String re_explanation;//原因

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

    @Override
    public String toString() {
        return "Reandpun{" +
                "re_id=" + re_id +
                ", re_reward=" + re_reward +
                ", re_punishment=" + re_punishment +
                ", re_explanation='" + re_explanation + '\'' +
                '}';
    }
}
