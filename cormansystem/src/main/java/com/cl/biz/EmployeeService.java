package com.cl.biz;

import com.cl.model.Employee;

/**
 * Created by one on 2018/4/23.
 */
public interface EmployeeService {
    Employee getEmployeeByid(int id);
    Employee getEmployeeByuid(int id);
    boolean addEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    boolean updateEmployeebystate(Employee employee);
}
