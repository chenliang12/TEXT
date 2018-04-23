package com.cl.dao;

import com.cl.model.Department;

import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
public interface DepartmentMapper {
    List<Department> getDepartment();
    Department getDepartmentbyid(int id);
    Department getDepartmentBydeid(Department department);
    boolean addDepartment(Department department);
    boolean updateDepartment(Department department);
    boolean deleteDepartment(Department department);
}
