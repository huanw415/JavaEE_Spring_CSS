package com.tw.dao;

import com.tw.entity.*;

import java.util.List;

/**
 * Created by hgwang on 8/3/15.
 */
public interface Dao<T> {

    List<T> getDataList(Class<T> tClass);

    T getDataById(int id, Class<T> tClass);

    T getDataByName(String name, Class<T> tClass);

    void createData(T data);

    void deleteData(T data);

    void updateData(T data);

    void updateUser(User user);

    void updateNameCustomer(Customer customer, String customerName);

    void updateCourseOfCustomer(Course course, Customer customer);

    List<Employee> getAllCoaches();

    List<Course> getCourseByCoach(Employee employee);

    List<Schedule> getTimeListOfCourse(Course course);

    List<Course> getPrivateCourse();
}
