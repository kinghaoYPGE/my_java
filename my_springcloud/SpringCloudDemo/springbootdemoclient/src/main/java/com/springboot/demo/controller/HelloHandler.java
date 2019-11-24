package com.springboot.demo.controller;

import com.springboot.demo.view.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/hello")
public class HelloHandler {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String providerUrl;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", restTemplate.getForObject(providerUrl+"findAll", Collection.class));
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/find/{id}")
    public ModelAndView find(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("update");
        mv.addObject("student", restTemplate.getForObject(providerUrl+"find/{id}", Student.class, id));
        return mv;
    }

    @PostMapping("/save")
    public String save(Student student) {
        restTemplate.postForObject(providerUrl+"save", student, Student.class);
        return "redirect:index";
    }
    @PostMapping("/valid/save")
    public ModelAndView validSave(@Valid Student student, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        if(br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<ObjectError> errors = br.getAllErrors();
            for(ObjectError oe: errors) {
               sb.append(oe.getCode() + ":" + oe.getDefaultMessage());
            }
            mv.setViewName("save");
            mv.addObject("error", sb.toString());
        } else {
            mv = index();
        }

        return mv;

    }

    @PostMapping("/update")
    public String update(Student student) {
        restTemplate.put(providerUrl+"update", student);
        return "redirect:index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        restTemplate.delete(providerUrl+"delete/{id}", id);
        return "redirect:index";
    }

    @GetMapping("/redirect/{location}")
    public String toPage(@PathVariable("location") String location) {
        return location;
    }

}
