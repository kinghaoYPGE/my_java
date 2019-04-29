package com.mymybatis.model;

import java.util.List;

public class Classes {
    private Integer id;
    private String name;
    // 一对一
    private HeadTeacher teacher;
    // 一对多
    private List<Student> students;

    public Classes() {

    }

    public Classes(Integer id, String name, HeadTeacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeadTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(HeadTeacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}