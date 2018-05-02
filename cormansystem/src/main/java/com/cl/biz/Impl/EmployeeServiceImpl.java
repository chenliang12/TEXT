package com.cl.biz.Impl;

import com.cl.biz.EmployeeService;
import com.cl.dao.EmployeeMapper;
import com.cl.model.Employee;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by one on 2018/4/23.
 */
@Controller
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public Employee getEmployeeByid(int id) {
        return employeeMapper.getEmployeeByid(id);
    }

    @Override
    public Employee getEmployeeByuid(int id) {
        return employeeMapper.getEmployeeByuid(id);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeMapper.addEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }

    @Override
    public boolean updateEmployeebystate(Employee employee) {
        return employeeMapper.updateEmployeebystate(employee);
    }
}
