package com.cl.biz.Impl;

import com.cl.biz.DepartmentService;
import com.cl.dao.DepartmentMapper;
import com.cl.model.Department;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
@Controller
public class DepartmentServiceImpl  implements DepartmentService{
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public List<Department> getDepartment() {
        return departmentMapper.getDepartment();
    }

    @Override
    public Department getDepartmentbyid(int id) {
        return departmentMapper.getDepartmentbyid(id);
    }

    @Override
    public Department getDepartmentBydeid(Department department) {
        return departmentMapper.getDepartmentBydeid(department);
    }

    @Override
    public boolean addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }

    @Override
    public boolean updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    @Override
    public boolean deleteDepartment(Department department) {
        return departmentMapper.deleteDepartment(department);
    }
}
