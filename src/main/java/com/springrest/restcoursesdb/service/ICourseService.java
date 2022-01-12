package com.springrest.restcoursesdb.service;

import com.springrest.restcoursesdb.entity.Course;

import java.util.List;

public interface ICourseService {

    public List<Course> getCourses();

    public Course getCourse(Long courseId);

    String deleteCourse(long courseId);

    String addCourse(Course course);

    String updateCourse(Course course);
}
