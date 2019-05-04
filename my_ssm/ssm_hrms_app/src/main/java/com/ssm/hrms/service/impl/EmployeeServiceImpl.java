package com.ssm.hrms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.hrms.dao.EmployeeDao;
import com.ssm.hrms.domain.Employee;
import com.ssm.hrms.domain.Post;
import com.ssm.hrms.service.EmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Post> findEmployees(Map<String, Object> map) {

        return employeeDao.findEmployees(map);
    }

    public Integer getCount(Map<String, Object> map) {

        return employeeDao.getCount(map);
    }

    public Integer addEmployee(Employee employee) {
        Integer flag = null;
        try {
            //如果插入主键重复，抛出异常
            flag =  employeeDao.addEmployee(employee);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        return flag;
    }

    public Integer updateEmployee(Employee employee) {

        return employeeDao.updateEmployee(employee);
    }

    public Integer deleteEmployee(String id) {

        return employeeDao.deleteEmployee(id);
    }

}