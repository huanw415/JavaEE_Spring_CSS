package com.tw.controller.angular_controller;

import com.tw.entity.Employee;
import com.tw.entity.User;
import com.tw.service.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by hgwang on 8/4/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@WebAppConfiguration
public class UsersControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UsersController usersController;

    @BeforeClass
    public static void setSystemProperty() {

        System.setProperty("spring.profiles.active", "test");
    }

    @Before
    public void build_usersController(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
    }

    @Test
    public void test_getAllUsers_method() throws Exception {
        List<User> users = new ArrayList<User>();
        users.add(new User("Lily", "123456", new Employee("Lily", "Coach", "male", "123@qq.com", 34)));
        users.add(new User("Ada", "123456", new Employee("Ada", "OPs", "female", "ada@qq.com", 24)));

        when(userService.getAllUsers()).thenReturn(users);

        this.mockMvc.perform(get("/users"))
                .andExpect(status().isOk());

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void test() throws Exception {
        assertEquals(1,1);
    }
}
