package com.cl.dao;

import com.cl.model.Recruitment;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by one on 2018/4/22.
 */

public interface RecruitmentDao {
    List<Recruitment> getRecruitment();
    boolean addRecruitment(Recruitment recruitment);
    boolean updateRecruitment(Recruitment recruitment);
    boolean deleteRecruitment(Recruitment recruitment);
    Recruitment getRecruitmentByjob(String job);
}
