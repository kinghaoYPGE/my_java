package com.springcloud.demo.controller;

import com.springcloud.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class StudentHandler {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection findAll() {
        return restTemplate.getForObject("http://localhost:8010/student/findAll",
                Collection.class);
    }

    @GetMapping("/find/{id}")
    public Student findById(@PathVariable("id") long id) {
        return restTemplate.getForObject("http://localhost:8010/student/find/{id}",
                Student.class, id);
    }

    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return restTemplate.postForObject("http://localhost:8010/student/save", student, Student.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        restTemplate.put("http://localhost:8010/student/update", student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") long id) {
        restTemplate.delete("http://localhost:8010/student/delete/{id}", id);
    }



}
