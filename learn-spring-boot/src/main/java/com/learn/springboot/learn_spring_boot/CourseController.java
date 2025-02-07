package com.learn.springboot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retriveAllCourses(){
        return Arrays.asList(
            new Course(1, "Learn AWS", "Udemy"),
            new Course(2, "Learn Azure", "Lex"),
            new Course(3, "Learn GCP", "Youtube"),
            new Course(4, "Learn DevOps", "Hungurycode")
        );
    }

}
