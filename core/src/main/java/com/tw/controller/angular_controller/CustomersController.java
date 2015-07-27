package com.tw.controller.angular_controller;

import com.tw.entity.Customer;
import com.tw.service.CustomerService;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@PathVariable int id,
                               @RequestParam String name){
        customerService.updateNameCustomer(customerService.getCustomerById(id), name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomerById(@PathVariable int id){
        customerService.deleteCustomer(customerService.getCustomerById(id));
    }
}
