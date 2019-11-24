package com.springcloud.demo.controller;

import com.springcloud.demo.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springcloud.demo.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Value("${server.port}")
    private int port;

    @Autowired
    private MenuService menuService;

    @GetMapping("/index")
    public String index() {
        return "菜单模块的端口是：" + port;
    }

    @GetMapping("/save")
    public Menu save() {
        Menu menu = new Menu();
        menu.setName("火锅");
        menu.setFlavor("四川");
        return (menuService.save(menu));
    }

    @GetMapping("/findAll")
    public List<Menu> findAll() {
        return menuService.findAll();
    }
}
