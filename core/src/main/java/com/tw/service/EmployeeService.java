package com.tw.service;

import com.tw.dao.Dao;
import com.tw.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hgwang on 7/16/15.
 */

@Service
public class EmployeeService {

    @Autowired
    private Dao<Employee> employeeDao;

    public List<Employee> getAllEmployees(){
        return employeeDao.getDataList(Employee.class);
    }
    public Employee getEmployeeById(int id){
        return employeeDao.getDataById(id, Employee.class);
    }

    public void updateEmployee(Employee employee){
        employeeDao.updateData(employee);
    }
    public void createEmployee(Employee employee){
        employeeDao.createData(employee);
    }

    public Employee getEmployeeByName(String coachName) {
        return  employeeDao.getDataByName(coachName, Employee.class);
    }
}