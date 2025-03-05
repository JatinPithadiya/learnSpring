package com.learn.springboot.data.learn_jpa_and_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.springboot.data.learn_jpa_and_hibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer>{
    public List<Course> findByAurthor(String aurthor);
    public List<Course> findByName(String name);
}
