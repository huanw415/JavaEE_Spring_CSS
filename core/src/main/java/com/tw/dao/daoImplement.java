package com.tw.dao;


import com.tw.Util.HibernateUtil;
import com.tw.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by hgwang on 8/3/15.
 */
@Repository
@EnableTransactionManagement
@Transactional
public class DaoImplement<T> implements Dao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<T> getDataList(Class<T> tClass) {

        Session session = sessionFactory.getCurrentSession();

        List<T> dataList = session.createCriteria(tClass).list();

        return dataList;
    }

    @Override
    public T getDataById(int id, Class<T> tClass) {

        Session session = sessionFactory.getCurrentSession();


        String className = tClass.getName().substring(14);

        String hql = "FROM " + className  + " where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        T data = (T)query.list().get(0);


        return data;
    }

    @Override
    public T getDataByName(String name, Class<T> tClass) {

        Session session = sessionFactory.getCurrentSession();

        String className = tClass.getName().substring(14);

        String hql = "FROM " + className  + " where name=:name";
        Query query = session.createQuery(hql);
        query.setString("name", name);

        T data = (T)query.list().get(0);

        return data;
    }

    @Override
    public void createData(T data) {

        Session session = sessionFactory.getCurrentSession();
        session.save(data);
    }

    @Override
    public void deleteData(T data) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.delete(data);
    }

    @Override
    public void updateData(T data) {

        Session session = sessionFactory.getCurrentSession();
        session.update(data);
    }

    @Override
    public void updateUser(User user) {

        Session session = sessionFactory.getCurrentSession();

        String hql = "update User t set t.name=:name, password=:password where id=:id";
        Query query = session.createQuery(hql);
        query.setString("name", user.getName());
        query.setString("password", user.getPassword());
        query.setInteger("id", user.getId());

        query.executeUpdate();

    }

    @Override
    public void updateNameCustomer(Customer customer, String customerName) {

        Session session = sessionFactory.getCurrentSession();

        String hql = "update Customer t set t.name=:name where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", customer.getId());
        query.setString("name", customerName);
        query.executeUpdate();
    }

    @Override
    public void updateCourseOfCustomer(Course course, Customer customer) {

        List<Course> courses = customer.getCourses();
        courses.add(course);
        customer.setCourses(courses);

        Session session = sessionFactory.getCurrentSession();

        session.update(customer);
    }

    @Override
    public List<Employee> getAllCoaches(){

        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Employee where Role=:role";
        Query query = session.createQuery(hql);
        query.setString("role", "coach");
        List<Employee> employees = query.list();

        return employees;
    }

    @Override
    public List<Course> getCourseByCoach(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        Query query= session.createQuery("FROM Course where employee=:employee");
        query.setParameter("employee", employee);
        List<Course> courses = query.list();

        return courses;
    }

    @Override
    public List<Schedule> getTimeListOfCourse(Course course) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Schedule where course=:course");
        query.setParameter("course", course);

        List<Schedule> schedules = query.list();

        return schedules;
    }
}
