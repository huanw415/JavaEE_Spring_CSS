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
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    private Gson gson = new GsonBuilder().setExclusionStrategies()
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

//    private JSONSerializer jsonSerializer = new JSONSerializer();

    @RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getAllUsers(){
//        return jsonSerializer.include("employee").serialize(userService.getAllUsers());
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

        currentUser.setId(id);
        currentUser.setPassword(Md5Util.md5(currentUser.getPassword()));

        userService.updateUser(currentUser);
    }

    @RequestMapping(method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public void createUser( @RequestParam String name,
                            @RequestParam String password,
                            @RequestParam String employeeName){
        User user = new User(name, Md5Util.md5(password), employeeService.getEmployeeByName(employeeName));
        userService.createUser(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable int id){
        userService.deleteUser(userService.getUserById(id));
    }
}