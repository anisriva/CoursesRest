package com.springrest.restcoursesdb.service;

import com.springrest.restcoursesdb.dao.ICourseDao;
import com.springrest.restcoursesdb.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements ICourseService{

//    List<Course> courses;
    @Autowired
    private ICourseDao courses;

    public CourseServiceImpl(List<Course> courses) {
//        this.courses = new ArrayList<>();
//        this.courses.add(new Course(1,"Learn Spring","Spring and Rest"));
//        this.courses.add(new Course(2,"Learn Django","Django and Rest"));
//        this.courses.add(new Course(3,"Learn Machine Learning","ML"));
    }

    @Override
    public List<Course> getCourses() {
        return courses.findAll();
    }

    @Override
    public Course getCourse(Long courseId) {
        return courses.getById(courseId);
    }

    @Override
    public String deleteCourse(long courseId) {
//        courses = courses.stream().filter(course -> course.getId()!=courseId).collect(Collectors.toList());
        courses.deleteById(courseId);
        return "Course with couseId "+courseId+" was removed";
    }

    @Override
    public String addCourse(Course course) {
        courses.save(course);
        return "Added : "+course;
    }

    @Override
    public String updateCourse(Course course) {
//        AtomicInteger recs = new AtomicInteger();
//        courses.forEach(cr -> {
//            if (cr.getId() == course.getId()) {
//                cr.setName(course.getName());
//                cr.setDescription(course.getDescription());
//                recs.getAndIncrement();
//            }
//        });
        int recs = 0;
        if (courses.existsById(course.getId())) {
            courses.save(course);
            recs++;
        }
        return "Successfully updated "+recs+" records";
    }
}
