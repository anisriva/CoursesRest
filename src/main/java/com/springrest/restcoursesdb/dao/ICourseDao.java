package com.springrest.restcoursesdb.dao;
import com.springrest.restcoursesdb.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseDao extends JpaRepository<Course, Long> {
}
