package com.tw.dao;


import com.tw.Util.HibernateUtil;
import com.tw.entity.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 8/3/15.
 */
@Repository
public class DaoImplement<T> implements Dao<T> {
    @Override
    public List<T> getDataList(Class<T> tClass) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        List<T> dataList = session.createCriteria(tClass).list();
        session.getTransaction().commit();

        return dataList;
    }

    @Override
    public T getDataById(int id, Class<T> tClass) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String className = tClass.getName().substring(14);

        String hql = "FROM " + className  + " where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        T data = (T)query.list().get(0);

        session.getTransaction().commit();

        return data;
    }

    @Override
    public T getDataByName(String name, Class<T> tClass) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String className = tClass.getName().substring(14);

        String hql = "FROM " + className  + " where name=:name";
        Query query = session.createQuery(hql);
        query.setString("name", name);

        T data = (T)query.list().get(0);

        session.getTransaction().commit();
        return data;
    }

    @Override
    public void createData(T data) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.save(data);
        session.getTransaction().commit();
    }

    @Override
    public void deleteData(T data) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.delete(data);
        session.getTransaction().commit();
    }

    @Override
    public void updateData(T data) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.update(data);
        session.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String hql = "update User t set t.name=:name, password=:password where id=:id";
        Query query = session.createQuery(hql);
        query.setString("name", user.getName());
        query.setString("password", user.getPassword());
        query.setInteger("id", user.getId());

        query.executeUpdate();

        session.getTransaction().commit();
    }

    @Override
    public void updateNameCustomer(Customer customer, String customerName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String hql = "update Customer t set t.name=:name where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", customer.getId());
        query.setString("name", customerName);
        query.executeUpdate();

        session.getTransaction().commit();
    }

    @Override
    public void updateCourseOfCustomer(Course course, Customer customer) {

        List<Course> courses = customer.getCourses();
        courses.add(course);
        customer.setCourses(courses);

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(customer);

        session.getTransaction().commit();
    }

    @Override
    public List<Employee> getAllCoaches(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String hql = "FROM Employee where Role=:role";
        Query query = session.createQuery(hql);
        query.setString("role", "coach");
        List<Employee> employees = query.list();

        session.getTransaction().commit();

        return employees;
    }

    @Override
    public List<Course> getCourseByCoach(Employee employee) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        Query query= session.createQuery("FROM Course where employee=:employee");
        query.setParameter("employee", employee);
        List<Course> courses = query.list();

        session.getTransaction().commit();

        return courses;
    }

    @Override
    public List<Schedule> getTimeListOfCourse(Course course) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        Query query = session.createQuery("from Schedule where course=:course");
        query.setParameter("course", course);

        List<Schedule> schedules = query.list();
        session.getTransaction().commit();

        return schedules;
    }
}
