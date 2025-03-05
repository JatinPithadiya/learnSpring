package com.learn.springboot.data.learn_jpa_and_hibernate.course.jpa;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.learn.springboot.data.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }

    public void deleteById(int id){
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    public Course getCourseById(int id){
       return entityManager.find(Course.class, id);
    }
}
