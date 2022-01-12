package com.springrest.restcoursesdb.controller;

import com.springrest.restcoursesdb.entity.Course;
import com.springrest.restcoursesdb.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "This is home!";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId){
        return courseService.getCourse(Long.parseLong(courseId));
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourseById(@PathVariable String courseId){
        try {
            courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/courses")
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public String updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }
}
