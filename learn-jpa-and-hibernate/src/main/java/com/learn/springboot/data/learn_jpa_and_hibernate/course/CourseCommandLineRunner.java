package com.learn.springboot.data.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.springboot.data.learn_jpa_and_hibernate.course.jdbc.CourseJDBCRepository;
import com.learn.springboot.data.learn_jpa_and_hibernate.course.jpa.CourseJPARepository;
import com.learn.springboot.data.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

  //  @Autowired
  //  private CourseJDBCRepository repository;

  //  @Autowired
  //  private CourseJPARepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
    // When used Spring jdbc or JPA
    //    repository.insert(new Course(1, "Learn Azure New", "Udemy"));
    //    repository.insert(new Course(2, "Learn GCP New", "Udemy"));
    //    repository.insert(new Course(3, "Learn AWS New", "Udemy"));

    //When used Spring Data JPA
        repository.save(new Course(1, "Learn Azure Spring Data JPA", "Udemy"));
        repository.save(new Course(2, "Learn GCP Spring Data JPA", "Udemy"));
        repository.save(new Course(3, "Learn AWS Spring Data JPA", "Udemy"));

        repository.deleteById(1);

        //When used spring jdbc and JPA
       // System.out.println(repository.getCourseById(2));
       // System.out.println(repository.getCourseById(3));

       //When used Spring Data JPA
       System.out.println(repository.findById(2));
       System.out.println(repository.findById(3));

       System.out.println(repository.findAll());
       System.out.println(repository.count());

       System.out.println(repository.findByAurthor("Udemy"));

       System.out.println(repository.findByName("Learn GCP Spring Data JPA"));
    }



}
