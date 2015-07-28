package com.tw.controller.angular_controller;

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
}