package com.cl.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by one on 2018/4/20.
 */
public class Train implements Serializable{//培训
    private int t_id;
    private String title;//培训主题
    private String content;//培训内容
    private String address;//培训地点
    private Date date;//培训时间

    public Train() {
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Train{" +
                "t_id=" + t_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", address='" + address + '\'' +
                ", date=" + date +
                '}';
    }
}
