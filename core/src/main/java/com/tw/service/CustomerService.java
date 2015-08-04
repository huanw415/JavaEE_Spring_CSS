package com.tw.service;

import com.tw.dao.Dao;
import com.tw.entity.Course;
import com.tw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */
@Service
public class CustomerService {

//    @Autowired
//    CustomerDao customerDao;

    @Autowired
    private Dao<Customer> customerDaos;

    public List<Customer> getAllCustomers(){
        return customerDaos.getDataList(Customer.class);
    }

    public Customer getCustomerById(int customerId) {
        return customerDaos.getDataById(customerId, Customer.class);
    }

    public Customer getCustomerByName(String customerName){
        return customerDaos.getDataByName(customerName, Customer.class);
    }

//    public List<Customer> getCustomersWithOutPrivate(){
//        List<Customer> customers = customerDao.getAllCustomers();
//        List<Customer> customerResultList = new ArrayList<Customer>();
//
//        for (Customer customer : customers) {
//            int times = 0;
//
//            List<Course> courses = customer.getCourses();
//
//            for (Course course : courses) {
//
//                if (course.getName().equals("private")) {
//                    times++;
//                }
//            }
//
//            if (times == 0) {
//                customerResultList.add(customer);
//            }
//        }
//        return customerResultList;
//    }

    public void updateCourseOfCustomer(Course course, Customer customer) {
        customerDaos.updateCourseOfCustomer(course, customer);
    }

    public void createCustomer(Customer customer) {
        customerDaos.createData(customer);
    }

    public void updateNameCustomer(Customer customer, String customerName) {

        customerDaos.updateNameCustomer(customer, customerName);
    }

    public void deleteCustomer(Customer customer) {
        if(customer.getCourses().size() == 0){
            customerDaos.deleteData(customer);
        }
    }

    public void updateCustomer(Customer customer){
        customerDaos.updateData(customer);
    }
}
