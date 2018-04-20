package com.cl.model;

import java.io.Serializable;

/**
 * Created by one on 2018/4/20.
 */
public class Reandpun implements Serializable {//奖惩
    private int re_id;
    private int reward;//奖励金额
    private int punishment;//惩罚金额
    private String explanation;//原因

    public Reandpun() {
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getPunishment() {
        return punishment;
    }

    public void setPunishment(int punishment) {
        this.punishment = punishment;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "Reandpun{" +
                "re_id=" + re_id +
                ", reward=" + reward +
                ", punishment=" + punishment +
                ", explanation='" + explanation + '\'' +
                '}';
    }
}
