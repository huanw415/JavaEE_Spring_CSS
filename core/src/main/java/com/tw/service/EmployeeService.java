package com.tw.service;

import com.tw.dao.DaoImplement;
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
    private DaoImplement<Employee> employeeDaoImplement;

    public List<Employee> getAllEmployees(){
        return employeeDaoImplement.getDataList(Employee.class);
    }
    public Employee getEmployeeById(int id){
        return employeeDaoImplement.getDataById(id, Employee.class);
    }

    public void updateEmployee(Employee employee){
        employeeDaoImplement.updateData(employee);
    }
    public void createEmployee(Employee employee){
        employeeDaoImplement.createData(employee);
    }

    public Employee getEmployeeByName(String coachName) {
        return  employeeDaoImplement.getDataByName(coachName, Employee.class);
    }
}