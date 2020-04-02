package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import com.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public String add() {
        return "user-add";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-list");
        mv.addObject("list", userRepository.findAll());
        return mv;
    }

    @GetMapping("/update/{id}")
    public ModelAndView toUpdate(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-update");
        mv.addObject("user", userRepository.findById(id));
        return mv;
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid User user, BindingResult bindingResult) {
        String message;
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()) {
            message = checkField(bindingResult);
        } else {
            userRepository.update(user);
            message = "修改成功";
        }
        mv.setViewName("user-update");
        mv.addObject("message", message);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return "redirect:/user/list";
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid User user, BindingResult bindingResult) {
        String message;
        ModelAndView mv = new ModelAndView();
        if(bindingResult.hasErrors()) {
            message = checkField(bindingResult);
        } else {
            userRepository.save(user);
            message = "添加成功";
        }
        mv.setViewName("user-add");
        mv.addObject("message", message);
        return mv;
    }

    private String checkField(BindingResult bindingResult) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        String message = allErrors.toString();
        return message;
    }

}
