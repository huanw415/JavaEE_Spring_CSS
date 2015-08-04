package com.tw.service;

import com.tw.dao.CourseDao;
import com.tw.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hgwang on 7/17/15.
 */
@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

//    @Autowired
//    private ScheduleDao scheduleDao;

    public List<Course> getAllCourses(){
        return courseDao.getAllCourses();
    }

    public Course getCourseById(int id){
        return courseDao.getCourseById(id);
    }

    public void updateCourse(Course course){
        courseDao.updateCourse(course);
    }
    public void createCourse(Course course){
        courseDao.createCourse(course);
    }

    public void deleteCourse(int id) {
        Course course = courseDao.getCourseById(id);
        courseDao.deleteCourse(course);
    }

    public Course getCourseByName(String name){
        return courseDao.getCourseByName(name);
    }

    public List<Course> getPrivateCourse() {
        return courseDao.getPrivateCourse();
    }
//
//    public List<Course> getCommonCourse(){
//        List<Course> courses = getAllCourses();
//
//        List<Course> commonCourses = new ArrayList<Course>();
//        for(int i=0; i<courses.size(); i++){
//            if(courses.get(i).getName() != "private"){
//                commonCourses.add(courses.get(i));
//            }
//        }
//
//        return commonCourses;
//    }

    public Course getCourseByPrivateCoach(String coachName){
        List<Course> privateCourses = getPrivateCourse();

        Course course = new Course();
        for(int i=0; i<privateCourses.size(); i++){

            if(privateCourses.get(i).getEmployee().getName().equals(coachName)){
                course = privateCourses.get(i);
            }
        }
        return course;
    }
}
