package com.tw.service;

import com.tw.dao.Dao;
import com.tw.entity.Course;
import com.tw.entity.Customer;
import com.tw.entity.Employee;
import com.tw.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hgwang on 7/20/15.
 */
@Service
public class ScheduleService {

    @Autowired
    private Dao<Schedule> scheduleDao;

    @Autowired
    private Dao<Course> courseDao;

    @Autowired
    private CustomerService customerService;

    public List<Schedule> getAllSchedules(){
        return scheduleDao.getDataList(Schedule.class);
    }

    public Schedule getScheduleById(int id){
        return scheduleDao.getDataById(id, Schedule.class);
    }

    public void updateSchedule(Schedule schedule){
        scheduleDao.updateData(schedule);
    }

    public List<String> getTimeListOfCourse(int courseId) {

        Employee employee = courseDao.getDataById(courseId, Course.class).getEmployee();
        List<Course> courses = courseDao.getCourseByCoach(employee);

        List<String> timeList = new ArrayList<String>();

        for(int i=0; i<courses.size(); i++){
            List<Schedule> scheduleList = scheduleDao.getTimeListOfCourse(courses.get(i));
            for(int j=0; j<scheduleList.size(); j++){
                timeList.add(scheduleList.get(j).getTime());
            }
        }

        return timeList;
    }

    public void createSchedule(int courseId, int customerId, String time) {
        Course course = courseDao.getDataById(courseId, Course.class);

        Schedule schedule;
        if(customerId == 0){
            schedule= new Schedule(time, course);
        }else {
            Customer customer = customerService.getCustomerById(customerId);
            customerService.updateCourseOfCustomer(course, customer);
            schedule = new Schedule(time, course, customer);

        }

        scheduleDao.createData(schedule);
    }

    public void deleteScheduleById(int id) {

        Schedule schedule = scheduleDao.getDataById(id, Schedule.class);
        Course currentCourse = schedule.getCourse();

        if(currentCourse.getName().equals("private")){

            Customer customer = schedule.getCustomer();
            List<Course> courses = customer.getCourses();

            for(int i=0; i<courses.size(); i++){
                if(courses.get(i).getName().equals("private")){
                    courses.remove(i);
                }
            }

            customerService.updateCustomer(customer);
        }
        scheduleDao.deleteData(schedule);
    }
}
