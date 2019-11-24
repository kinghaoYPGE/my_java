package com.springcloud.demo.controller;

import com.springcloud.demo.feign.MenuFeign;
import com.springcloud.demo.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/menu/findAll")
    @ResponseBody
    public List<Menu> findAll() {
        return menuFeign.findAll();
    }

    @GetMapping("/menu/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("menuList", menuFeign.findAll());
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

}
