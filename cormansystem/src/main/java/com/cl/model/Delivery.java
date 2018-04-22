package com.cl.model;

import java.io.Serializable;

/**
 * Created by one on 2018/4/22.
 */
public class Delivery implements Serializable{
    private int de_id;
    private String de_state;
    private Postitions postitions;
    private Recruitment recruitment;
    private User user;
    private Resume resume;

    public Delivery() {
    }

    public int getDe_id() {
        return de_id;
    }

    public void setDe_id(int de_id) {
        this.de_id = de_id;
    }

    public String getDe_state() {
        return de_state;
    }

    public void setDe_state(String de_state) {
        this.de_state = de_state;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Postitions getPostitions() {
        return postitions;
    }

    public void setPostitions(Postitions postitions) {
        this.postitions = postitions;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "de_id=" + de_id +
                ", de_state='" + de_state + '\'' +
                '}';
    }
}
