package com.cl.biz;

import com.cl.model.Dissent;

import java.util.List;

/**
 * Created by one on 2018/5/2.
 */
public interface DissentService {
    List<Dissent> getDissentbyeid(int id);
    boolean addDissent(Dissent dissent);
    boolean updateDissent(Dissent dissent);
    boolean deleteDissent(Dissent dissent);
    List<Dissent> getDissents();
    Dissent getDissentByid(int id);
}
