package com.cl.biz;

import com.cl.model.Postitions;

import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
public interface PostitionesService {
    List<Postitions> getPostitions();
    List<Postitions> getPostitionsbydeid(int id);
    boolean addPostitions(Postitions postitions);
    boolean updatePostitions(Postitions postitions);
    boolean deletePostitions(Postitions postitions);
    Postitions getPostitionsbyid(int id);
    Postitions getPostitonsByuid(int id);
    Postitions getPostitonsByname(String name);
    Postitions getPostitonsBynamenoemploy(String name);
    boolean updatePostitionsByuande(Postitions postitions);
}
