package com.cl.dao;

import com.cl.model.Postitions;

import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
public interface PostitionesMapper {
    List<Postitions> getPostitions();
    List<Postitions> getPostitionsbydeid(int id);
    boolean addPostitions(Postitions postitions);
    boolean updatePostitions(Postitions postitions);
    boolean deletePostitions(Postitions postitions);
    Postitions getPostitionsbyid(int id);
    Postitions getPostitonsByuid(int id);
    Postitions getPostitonsByname(String name);
}
