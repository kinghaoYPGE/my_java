package com.springboot.demo.controller;

import com.springboot.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @GetMapping("/")
    public String index() {
        return "user-add";
    }

    @PostMapping("/add")
    public ModelAndView add(@Valid User user, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user-add");
        String message;
        if(bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            message = allErrors.toString();
        } else {
            message = "添加成功";
        }
        mv.addObject("message", message);
        return mv;
    }

}
