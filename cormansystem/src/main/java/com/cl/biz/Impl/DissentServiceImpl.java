package com.cl.biz.Impl;

import com.cl.biz.DissentService;
import com.cl.dao.DissentMapper;
import com.cl.model.Dissent;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by one on 2018/5/2.
 */
@Controller
public class DissentServiceImpl implements DissentService{
    @Resource
    private DissentMapper dissentMapper;
    @Override
    public List<Dissent> getDissentbyeid(int id) {
        return dissentMapper.getDissentbyeid(id);
    }

    @Override
    public boolean addDissent(Dissent dissent) {
        return dissentMapper.addDissent(dissent);
    }

    @Override
    public boolean updateDissent(Dissent dissent) {
        return dissentMapper.updateDissent(dissent);
    }

    @Override
    public boolean deleteDissent(Dissent dissent) {
        return dissentMapper.deleteDissent(dissent);
    }

    @Override
    public List<Dissent> getDissents() {
        return dissentMapper.getDissents();
    }

    @Override
    public Dissent getDissentByid(int id) {
        return dissentMapper.getDissentByid(id);
    }
}
