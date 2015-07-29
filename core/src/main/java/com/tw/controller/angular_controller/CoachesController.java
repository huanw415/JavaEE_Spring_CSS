package com.tw.controller.angular_controller;

import com.tw.entity.Course;
import com.tw.entity.Employee;
import com.tw.service.CoachService;
import com.tw.service.CourseService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hgwang on 7/27/15.
 */

@RestController
@RequestMapping(value = "/api/coaches")
public class CoachesController {

    @Autowired
    private CoachService coachService;

    @Autowired
    private CourseService courseService;

    private JSONSerializer jsonSerializer= new JSONSerializer();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getAllCoaches(){
        return jsonSerializer.serialize(coachService.getAllCoaches());
    }

    @RequestMapping(value = "/privateCoaches", method = RequestMethod.GET)
    public @ResponseBody
    String getPrivateCoaches(){

        List<Course> courses = courseService.getPrivateCourse();
        List<Employee> coaches = new ArrayList<Employee>();

        for(int i=0; i<courses.size(); i++){
            coaches.add(courses.get(i).getEmployee());
        }
        return jsonSerializer.serialize(coaches);
    }
}
