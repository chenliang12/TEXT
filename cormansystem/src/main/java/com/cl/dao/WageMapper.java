package com.cl.dao;

import com.cl.model.Wage;

import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
public interface WageMapper {
    List<Wage> getWageByuid(int id);
    boolean addWage(Wage wage);
    boolean updateWage(Wage wage);
    boolean deleteWage(Wage wage);
}
