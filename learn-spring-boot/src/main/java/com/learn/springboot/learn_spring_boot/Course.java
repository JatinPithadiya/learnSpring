package com.learn.springboot.learn_spring_boot;

public class Course {

    private int id;
    private String courseName;
    private String author;

    public Course(int id, String courseName, String author) {
        this.id = id;
        this.courseName = courseName;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", courseName=" + courseName + ", author=" + author + "]";
    }

    
    

}
