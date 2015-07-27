package com.tw.controller.angular_controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.Util.HibernateProxyTypeAdapter;
import com.tw.service.CustomerService;
import com.tw.service.EmployeeService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hgwang on 7/27/15.
 */

@RestController
@RequestMapping(value = "/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    private Gson gson = new GsonBuilder().setExclusionStrategies()
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getAllEmployees(){
        return new JSONSerializer().include("courses").serialize(customerService.getAllCustomers());
    }
}
