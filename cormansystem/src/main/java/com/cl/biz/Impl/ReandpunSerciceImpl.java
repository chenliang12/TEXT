package com.cl.biz.Impl;

import com.cl.biz.ReandpunService;
import com.cl.dao.ReandpunMapper;
import com.cl.model.Reandpun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Created by one on 2018/4/24.
 */
@Controller
public class ReandpunSerciceImpl implements ReandpunService {
    @Autowired
    private ReandpunMapper reandpunMapper;

    @Override
    public List<Reandpun> getReandpun() {
        return reandpunMapper.getReandpun();
    }

    @Override
    public List<Reandpun> getReandpunByuid(int id) {
        return reandpunMapper.getReandpunByuid(id);
    }

    @Override
    public boolean addReandpun(Reandpun reandpun) {
        return reandpunMapper.addReandpun(reandpun);
    }

    @Override
    public boolean updateReandpun(Reandpun reandpun) {
        return reandpunMapper.updateReandpun(reandpun);
    }

    @Override
    public boolean deleteReandpun(Reandpun reandpun) {
        return reandpunMapper.deleteReandpun(reandpun);
    }

    @Override
    public Reandpun getReandpunByid(int id) {
        return reandpunMapper.getReandpunByid(id);
    }

    @Override
    public Reandpun getReanddpunByatt(Reandpun reandpun) {
        return reandpunMapper.getReanddpunByatt(reandpun);
    }

    @Override
    public boolean updateReandpunByexpl(Reandpun reandpun) {
        return reandpunMapper.updateReandpunByexpl(reandpun);
    }
}
