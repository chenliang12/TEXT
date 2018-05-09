package com.cl.biz.Impl;

import com.cl.biz.RecruitmentService;
import com.cl.dao.RecruitmentDao;
import com.cl.model.Recruitment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by one on 2018/4/22.
 */
@Service
public class RecruitmentServiceImpl implements RecruitmentService{

    @Resource
    private RecruitmentDao recruitmentDao;

    @Override
    public List<Recruitment> getRecruitment() {
        return recruitmentDao.getRecruitment();
    }

    @Override
    public boolean addRecruitment(Recruitment recruitment) {
        return recruitmentDao.addRecruitment(recruitment);
    }

    @Override
    public boolean updateRecruitment(Recruitment recruitment) {
        return recruitmentDao.updateRecruitment(recruitment);
    }

    @Override
    public boolean deleteRecruitment(Recruitment recruitment) {
        return recruitmentDao.deleteRecruitment(recruitment);
    }

    @Override
    public Recruitment getRecruitmentByjob(String job) {
        return recruitmentDao.getRecruitmentByjob(job);
    }

    @Override
    public Recruitment getRecruitmentByid(int id) {
        return recruitmentDao.getRecruitmentByid(id);
    }
}
