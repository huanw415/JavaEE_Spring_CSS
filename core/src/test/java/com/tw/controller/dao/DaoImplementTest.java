package com.tw.controller.dao;

import com.tw.dao.Dao;
import com.tw.entity.Employee;
import com.tw.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by hgwang on 8/4/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@Transactional
public class DaoImplementTest {

    @Autowired
    private Dao<User> userDao;

    @Autowired
    private Dao<Employee> EmployeeDao;

    @BeforeClass
    public static void setSystemProperty() {

        System.setProperty("spring.profiles.active", "test");
    }

    @Test
    public void test_getDataList_method_with_User(){
        List<User> users = userDao.getDataList(User.class);
        assertEquals(users.size(), 3);
    }

    @Test
    public void test_getDataById_method_with_User(){
        User user = userDao.getDataById(1, User.class);

        assertEquals(user.getId(), 1);
        assertEquals(user.getName(), "Tom");
    }

    @Test
    public void test_getDataByName_method_with_User(){
        User user = userDao.getDataByName("Ada", User.class);
        assertEquals(user.getId(), 2);
    }

    @Test
    public void test_createData_method_with_User(){
        User user = new User("ddddd", "111111111111", EmployeeDao.getDataById(1, Employee.class));
        userDao.createData(user);
        assertEquals(userDao.getDataList(User.class).size(), 4);
    }

    @Test
    public void test_updateData_method_with_User(){
        User user = new User();
        user.setId(1);
        user.setName("Tom~");
        user.setPassword("tom123");

        userDao.updateData(user);

        assertEquals(userDao.getDataById(1, User.class).getPassword(), "tom123");
        assertEquals(userDao.getDataById(1, User.class).getName(), "Tom~");
    }
}
