package com.springcloud.demo.repository.impl;

import com.springcloud.demo.entity.Student;
import com.springcloud.demo.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static Map<Long, Student> studentMap;

    static {
        studentMap = new HashMap<>();
        studentMap.put(1L, new Student(1L, "spring", 20));
        studentMap.put(2L, new Student(2L, "mybatis", 21));
        studentMap.put(3L, new Student(3L, "hibernate", 22));
        studentMap.put(4L, new Student(4L, "springMVC", 23));
        studentMap.put(5L, new Student(5L, "springBoot", 24));
    }

    @Override
    public Collection<Student> findAll() {
            return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public Student saveOrUpdate(Student student) {
        studentMap.put(student.getId(), student);
        return studentMap.get(student.getId());
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
