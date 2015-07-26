package com.tw.controller.angular_controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.Util.HibernateProxyTypeAdapter;
import com.tw.entity.Employee;
import com.tw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hgwang on 7/24/15.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    private Gson gson = new GsonBuilder().setExclusionStrategies()
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getAllEmployees(){
        return gson.toJson(employeeService.getAllEmployees());
    }

    @RequestMapping(method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }
}
