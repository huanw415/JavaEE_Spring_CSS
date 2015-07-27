package com.tw.controller.angular_controller;

import com.tw.service.CustomerService;
import com.tw.service.EmployeeService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hgwang on 7/27/15.
 */

@RestController
@RequestMapping(value = "/api/customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    private   JSONSerializer jsonSerializer= new JSONSerializer();

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getAllEmployees(){
        return jsonSerializer.include("courses").serialize(customerService.getAllCustomers());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    String getCustomerById(@PathVariable int id){
        return jsonSerializer.serialize(customerService.getCustomerById(id));
    }
}
