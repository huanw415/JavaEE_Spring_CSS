package com.tw.controller.angular_controller;

import com.tw.service.CourseService;
import com.tw.service.CustomerService;
import com.tw.service.ScheduleService;
import flexjson.JSONSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hgwang on 7/28/15.
 */
@RestController
@RequestMapping(value = "/api/schedules")
public class SchedulesController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CustomerService customerService;


    private JSONSerializer jsonSerializer= new JSONSerializer();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getAllSchedules(){
        return jsonSerializer.include("course", "customer").serialize(scheduleService.getAllSchedules());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSchedule(@PathVariable int id){
        scheduleService.deleteScheduleById(id);
    }

//    @RequestMapping(value = "/privateCreation", method = RequestMethod.POST)
//    public String createSchedule(@RequestParam String coachName,
//                                 @RequestParam String customerName,
//                                 @RequestParam String time){
//
//        System.out.println("===================================");
//        System.out.println("coachName: " + coachName);
//        System.out.println("customerName: " +customerName);
//        System.out.println("time: " + time);
//        System.out.println("===================================");
//
//        Course course = courseService.getCourseByName(courseName);
//        Customer customer = customerService.getCustomerByName(customerName);
//
//        List<String> timeList = scheduleService.getTimeListOfCourse(course.getId());
//
//        if(timeList.contains(time)){
//            return jsonSerializer.serialize("coach is busy");
//        }else{
//            scheduleService.createSchedule(course.getId(), customer.getId(), time);
//            return jsonSerializer.serialize("coach is not busy");
//        }
//    }
}