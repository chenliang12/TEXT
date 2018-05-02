package com.cl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by one on 2018/4/22.
 */
public class Attendance implements Serializable{//考勤
    private int a_id;
    private Date a_starttime;//上班时间
    private String starttime;
    private Date a_offtime;//下班时间
    private String offtime;
    private String a_state;//状态
    private Date a_date;
    private String date;
    private int year;
    private int month;
    private Employee employee;

    public Attendance() {
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public Date getA_starttime() {
        return a_starttime;
    }

    public void setA_starttime(Date a_starttime) {
        this.a_starttime = a_starttime;
    }

    public Date getA_offtime() {
        return a_offtime;
    }

    public void setA_offtime(Date a_offtime) {
        this.a_offtime = a_offtime;
    }

    public String getA_state() {
        return a_state;
    }

    public void setA_state(String a_state) {
        this.a_state = a_state;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getA_date() {
        return a_date;
    }

    public void setA_date(Date a_date) {
        this.a_date = a_date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getOfftime() {
        return offtime;
    }

    public void setOfftime(String offtime) {
        this.offtime = offtime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AttendanceMapper{" +
                "a_id=" + a_id +
                ", a_starttime=" + a_starttime +
                ", a_offtime=" + a_offtime +
                ", a_state='" + a_state + '\'' +
                '}';
    }
}
