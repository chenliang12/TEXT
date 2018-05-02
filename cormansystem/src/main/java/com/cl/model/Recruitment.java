package com.cl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by one on 2018/4/20.
 */
public class Recruitment implements Serializable {//招聘信息
    private int r_id;
    private String r_job;//职位
    private int r_wage;//基本工资
    private String r_demand;//工作要求
    private String r_treatment;//待遇
    private String r_workplace;//工作地点
    private String r_state;//状态
    private Date r_createtime;//发布时间
    private String createtime;
    public Recruitment() {
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_job() {
        return r_job;
    }

    public void setR_job(String r_job) {
        this.r_job = r_job;
    }

    public int getR_wage() {
        return r_wage;
    }

    public void setR_wage(int r_wage) {
        this.r_wage = r_wage;
    }

    public String getR_demand() {
        return r_demand;
    }

    public void setR_demand(String r_demand) {
        this.r_demand = r_demand;
    }

    public String getR_treatment() {
        return r_treatment;
    }

    public void setR_treatment(String r_treatment) {
        this.r_treatment = r_treatment;
    }

    public String getR_workplace() {
        return r_workplace;
    }

    public void setR_workplace(String r_workplace) {
        this.r_workplace = r_workplace;
    }

    public String getR_state() {
        return r_state;
    }

    public void setR_state(String r_state) {
        this.r_state = r_state;
    }

    public Date getR_createtime() {
        return r_createtime;
    }

    public void setR_createtime(Date r_createtime) {
        this.r_createtime = r_createtime;
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
                ", r_job='" + r_job + '\'' +
                ", r_wage=" + r_wage +
                ", r_demand='" + r_demand + '\'' +
                ", r_treatment='" + r_treatment + '\'' +
                ", r_workplace='" + r_workplace + '\'' +
                ", r_state='" + r_state + '\'' +
                ", r_createtime='" + r_createtime + '\'' +
                '}';
    }
}
