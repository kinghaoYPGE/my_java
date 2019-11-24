package com.springcloud.demo.repository;

import com.springcloud.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;

public interface StudentRepository {

    Collection<Student> findAll();

    Student findById(long id);

    Student saveOrUpdate(Student student);

    void deleteById(long id);
}
