package com.tw.service;

import com.tw.dao.Dao;
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
    private Dao<Course> courseDao;

    public List<Course> getAllCourses(){
        return courseDao.getDataList(Course.class);
    }

    public Course getCourseById(int id){
        return courseDao.getDataById(id, Course.class);
    }

    public void updateCourse(Course course){
        courseDao.updateData(course);
    }
    public void createCourse(Course course){
        courseDao.createData(course);
    }

    public void deleteCourse(int id) {

        Course course = courseDao.getDataById(id, Course.class);
        courseDao.deleteData(course);
    }

    public Course getCourseByName(String name){
        return courseDao.getDataByName(name, Course.class);
    }

    public List<Course> getPrivateCourse() {
        return courseDao.getPrivateCourse();
    }

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
