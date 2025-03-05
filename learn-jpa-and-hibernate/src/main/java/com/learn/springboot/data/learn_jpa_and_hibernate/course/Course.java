package com.learn.springboot.data.learn_jpa_and_hibernate.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {

    @Id
    private int id;
    private String name;
    private String aurthor;
    
    public Course() {
    }
    public Course(int id, String name, String aurthor) {
        this.id = id;
        this.name = name;
        this.aurthor = aurthor;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAurthor() {
        return aurthor;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAurthor(String aurthor) {
        this.aurthor = aurthor;
    }
    @Override
    public String toString() {
        return "Course [id=" + id + ", name=" + name + ", aurthor=" + aurthor + "]";
    }

    
}
