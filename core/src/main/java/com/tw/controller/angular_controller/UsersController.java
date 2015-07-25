package com.tw.controller.angular_controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.Util.HibernateProxyTypeAdapter;
import com.tw.Util.Md5Util;
import com.tw.entity.User;
import com.tw.service.EmployeeService;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hgwang on 7/23/15.
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    private Gson gson = new GsonBuilder().setExclusionStrategies()
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getAllUsers(){

        return gson.toJson(userService.getAllUsers());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getUserById(@PathVariable int id){

        return gson.toJson(userService.getUserById(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody User currentUser,
                      @PathVariable int id){

//        User user = userService.getUserById(id);
//        user.setName(currentUser.getName());
//        user.setPassword(currentUser.getPassword());
        currentUser.setId(id);
        System.out.println("========================");
        System.out.println(currentUser);
        System.out.println(currentUser.getId());
        System.out.println(currentUser.getName());
        System.out.println(currentUser.getPassword());
        System.out.println("========================");

        userService.updateUser(currentUser);
//        return gson.toJson(userService.getUserById(id));
    }

    @RequestMapping(method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public void createUser( @RequestParam String name,
                            @RequestParam String password,
                            @RequestParam String employeeName){
        User user = new User(name, Md5Util.md5(password), employeeService.getEmployeeByName(employeeName));
        userService.createUser(user);
    }
}