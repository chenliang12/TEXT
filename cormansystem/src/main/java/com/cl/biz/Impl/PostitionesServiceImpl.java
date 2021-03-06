package com.cl.biz.Impl;

import com.cl.biz.PostitionesService;
import com.cl.dao.PostitionesMapper;
import com.cl.model.Postitions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
@Service
public class PostitionesServiceImpl implements PostitionesService{
    @Resource
    private PostitionesMapper postitionesMapper;
    @Override
    public List<Postitions> getPostitions() {
        return postitionesMapper.getPostitions();
    }

    @Override
    public List<Postitions> getPostitionsbydeid(int id) {
        return postitionesMapper.getPostitionsbydeid(id);
    }

    @Override
    public boolean addPostitions(Postitions postitions) {
        return postitionesMapper.addPostitions(postitions);
    }

    @Override
    public boolean updatePostitions(Postitions postitions) {
        return postitionesMapper.updatePostitions(postitions);
    }

    @Override
    public boolean deletePostitions(Postitions postitions) {
        return postitionesMapper.deletePostitions(postitions);
    }

    @Override
    public Postitions getPostitionsbyid(int id) {
        return postitionesMapper.getPostitionsbyid(id);
    }

    @Override
    public Postitions getPostitonsByuid(int id) {
        return postitionesMapper.getPostitonsByuid(id);
    }

    @Override
    public Postitions getPostitonsByname(String name) {
        return postitionesMapper.getPostitonsByname(name);
    }

    @Override
    public Postitions getPostitonsBynamenoemploy(String name) {
        return postitionesMapper.getPostitonsBynamenoemploy(name);
    }

    @Override
    public boolean updatePostitionsByuande(Postitions postitions) {
        return postitionesMapper.updatePostitionsByuande(postitions);
    }
}
