package com.mymybatis.model;

import java.util.Date;

public class StudentCourse {
    private Student student;
    private Course course;
    private Date date;

    public StudentCourse() {

    }

    public StudentCourse(Student student, Course course, Date date) {
        this.student = student;
        this.course = course;
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}