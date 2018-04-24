package com.cl.dao;

import com.cl.model.Reandpun;

import java.util.List;

/**
 * Created by one on 2018/4/24.
 */
public interface ReandpunMapper {
    List<Reandpun> getReandpun();
    List<Reandpun> getReandpunByuid(int id);
    boolean addReandpun(Reandpun reandpun);
    boolean updateReandpun(Reandpun reandpun);
    boolean deleteReandpun(Reandpun reandpun);
    Reandpun getReandpunByid(int id);
}
