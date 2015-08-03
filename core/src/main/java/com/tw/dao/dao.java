package com.tw.dao;

import com.tw.entity.User;

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
}
