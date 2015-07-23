package com.tw.dao;

import com.tw.Util.HibernateUtil;
import com.tw.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hgwang on 7/16/15.
 */
@Repository
public class EmployeeDao {
    public List<Employee> getAllEmployees(){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        List<Employee> employees = session.createQuery("FROM Employee").list();

        session.getTransaction().commit();

        return employees;
    }

    public Employee getEmployeeById(int id){

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        String hql = "FROM Employee where id=:id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);

        Employee employee = (Employee) query.list().get(0);

        session.getTransaction().commit();

        return employee;
    }

    public void updateEmployee(Employee employee){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        session.update(employee);
        session.getTransaction().commit();
    }

    public void createEmployee(Employee employee){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
    }

    public Employee getEmployeeByName(String coachName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.beginTransaction();

        String hql = "FROM Employee where name=:name";
        Query query = session.createQuery(hql);
        query.setString("name", coachName);
        Employee employee = (Employee) query.list().get(0);

        session.getTransaction().commit();

        return employee;
    }
}

