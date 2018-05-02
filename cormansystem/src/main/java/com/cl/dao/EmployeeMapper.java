package com.cl.dao;

import com.cl.model.Employee;

import java.util.List;

/**
 * Created by one on 2018/4/23.
 */
public interface EmployeeMapper {
    Employee getEmployeeByid(int id);
    Employee getEmployeeByuid(int id);
    List<Employee> getEmployee();
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean updateEmployeebystate(Employee employee);
    boolean deleteEmployee(Employee employee);
}
