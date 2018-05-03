package com.cl.dao;

import com.cl.model.Dissent;

import java.util.List;

/**
 * Created by one on 2018/4/22.
 */
public interface DissentMapper {
    List<Dissent> getDissentbyeid(int id);
    boolean addDissent(Dissent dissent);
    boolean updateDissent(Dissent dissent);
    boolean deleteDissent(Dissent dissent);
    List<Dissent> getDissents();
    Dissent getDissentByid(int id);
}
