package com.springboot.demo.repository;

import com.springboot.demo.entity.Student;

import java.util.Collection;

public interface StudentRepository {
    Collection findAll();
    Student findById(long id);
    void saveOrUpdate(Student student);
    void deleteById(long id);
}
