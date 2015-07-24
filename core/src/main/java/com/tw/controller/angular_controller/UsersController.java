package com.tw.controller.angular_controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.Util.HibernateProxyTypeAdapter;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hgwang on 7/23/15.
 */
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UserService userService;

    private Gson gson = new GsonBuilder().setExclusionStrategies()
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String getAllUsers(){

        return gson.toJson(userService.getAllUsers());
    }
}