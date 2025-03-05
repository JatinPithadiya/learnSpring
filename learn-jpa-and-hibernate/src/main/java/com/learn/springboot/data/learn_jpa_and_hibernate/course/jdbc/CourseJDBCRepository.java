package com.learn.springboot.data.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learn.springboot.data.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJDBCRepository {

    @Autowired
    private JdbcTemplate spriJdbcTemplate;

    private static String INSERT_QUERY =
    """
        insert into course(id, name, aurthor) 
        values (?,?,?);
    """;

    private static String DELETE_QUERY =
    """
        delete from course 
        where id = ?;
    """;

    private static String SELECT_QUERY =
    """
        select * from course 
        where id = ?;
    """;

    public void insert(Course course){
        spriJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAurthor());
    }

    public void deleteById(int id){
        spriJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course getCourseById(int id){
       return spriJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
