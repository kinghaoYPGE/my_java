package com.myspringboot.mybatis.controller;

import com.myspringboot.mybatis.model.User;
import com.myspringboot.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }


    //使用post请求新建
    @PostMapping()
    public String save(User user) {
        userService.save(user);
        return "save success";
    }

    //使用put请求更新 会拦截类似/user/1这种形式的路径
    @PutMapping("{id}")
    public String update(User user, @PathVariable int id) {
        //当数据不存在时，不允许更新
        if (userService.findById(id) == null) {
            return "Not Exist";
        }
        //防止传入的id不一致，如user中id属性是2，而url路径中id为1；
        if (user.getId() != id) {
            return "Unmatched parameters";
        }
        userService.update(user);
        return "update success";
    }

    //使用delete请求删除
    @DeleteMapping("{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "delete success";
    }

    //使用get方法查询
    @GetMapping()
    public List<User> list() {
        return userService.list();
    }

    //使用get方法查询单个数据
    @GetMapping("{id}")
    public User getById(@PathVariable int id) {
        return userService.findById(id);
    }
}