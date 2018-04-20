package com.cl.model;

import java.io.Serializable;

/**
 * Created by one on 2018/4/20.
 */
public class Recruitment implements Serializable {//招聘信息
    private int r_id;
    private String job;//职位
    private int wage;//基本工资
    private String demand;//工作要求
    private String treatment;//待遇
    private String workplace;//工作地点
    private String state;//状态
    private String createtime;//发布时间

    public Recruitment() {
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "r_id=" + r_id +
                ", job='" + job + '\'' +
                ", wage=" + wage +
                ", demand='" + demand + '\'' +
                ", treatment='" + treatment + '\'' +
                ", workplace='" + workplace + '\'' +
                ", state='" + state + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
