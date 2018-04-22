package com.cl.biz;

import com.cl.model.Resume;

import java.util.List;

/**
 * Created by one on 2018/4/22.
 */
public interface ResumeService {
    Resume getResumebyuid(int id);
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean deleteResume(Resume resume);
}
