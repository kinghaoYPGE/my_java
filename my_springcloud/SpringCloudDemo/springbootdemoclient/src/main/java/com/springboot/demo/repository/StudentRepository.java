package com.springboot.demo.repository;

import com.springboot.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * spring data jpa
 */
public interface StudentRepository extends CrudRepository<Student, Long> {

}
