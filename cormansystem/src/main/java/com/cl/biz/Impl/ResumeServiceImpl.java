package com.cl.biz.Impl;

import com.cl.biz.ResumeService;
import com.cl.dao.ResumeDao;
import com.cl.model.Resume;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by one on 2018/4/22.
 */
@Service
public class ResumeServiceImpl implements ResumeService{
    @Resource
    private ResumeDao resumeDao;
    @Override
    public Resume getResumebyuid(int id) {
        return resumeDao.getResumebyuid(id);
    }

    @Override
    public boolean addResume(Resume resume) {
        return resumeDao.addResume(resume);
    }

    @Override
    public boolean updateResume(Resume resume) {
        return resumeDao.updateResume(resume);
    }

    @Override
    public boolean deleteResume(Resume resume) {
        return resumeDao.deleteResume(resume);
    }
}
