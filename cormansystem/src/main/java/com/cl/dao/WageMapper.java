package com.cl.dao;

import com.cl.model.Wage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
public interface WageMapper {
    List<Wage> getWages();
    List<Wage> getWageByuid(int id);
    boolean addWage(Wage wage);
    boolean updateWage(Wage wage);
    boolean deleteWage(Wage wage);
    Wage getWage(@Param("year") int year, @Param("month") int month, @Param("eid") int eid);
}
