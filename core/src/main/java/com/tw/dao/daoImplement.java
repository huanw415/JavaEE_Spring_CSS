package com.tw.dao;


import com.tw.Util.HibernateUtil;
import com.tw.entity.User;
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
}
