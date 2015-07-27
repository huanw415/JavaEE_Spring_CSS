package com.tw.controller.angular_controller;

import com.tw.service.CourseService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hgwang on 7/27/15.
 */
@RestController
@RequestMapping(value = "/api/courses")
public class CoursesController {

    @Autowired
    private CourseService courseService;

    private JSONSerializer jsonSerializer= new JSONSerializer();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getAllCourses(){
        return jsonSerializer.include("employee").serialize(courseService.getAllCourses());
    }
}
