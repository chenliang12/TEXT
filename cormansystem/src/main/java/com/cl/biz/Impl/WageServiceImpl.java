package com.cl.biz.Impl;

import com.cl.biz.WageService;
import com.cl.dao.WageMapper;
import com.cl.model.Wage;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by one on 2018/4/30.
 */
@Controller
public class WageServiceImpl implements WageService {
    @Resource
    private WageMapper wageMapper;
    @Override
    public List<Wage> getWages() {
        return wageMapper.getWages();
    }

    @Override
    public List<Wage> getWageByuid(int id) {
        return wageMapper.getWageByuid(id);
    }

    @Override
    public boolean addWage(Wage wage) {
        return wageMapper.addWage(wage);
    }

    @Override
    public boolean updateWage(Wage wage) {
        return wageMapper.updateWage(wage);
    }

    @Override
    public boolean deleteWage(Wage wage) {
        return wageMapper.deleteWage(wage);
    }

    @Override
    public Wage getWage(int year, int month, int eid) {
        return wageMapper.getWage(year,month,eid);
    }
}
