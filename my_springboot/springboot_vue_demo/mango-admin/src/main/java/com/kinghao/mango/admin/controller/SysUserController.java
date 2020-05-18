package com.kinghao.mango.admin.controller;

import com.kinghao.mango.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

}
