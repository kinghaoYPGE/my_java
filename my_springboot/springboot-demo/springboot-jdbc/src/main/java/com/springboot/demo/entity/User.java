package com.springboot.demo.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull(message = "ID不能为空")
    private Long id;
    @NotEmpty(message = "用户名不能为空")
    @Length(min = 4, max = 10, message = "用户名长度在4到10之间")
    private String name;
    @Min(value = 18, message = "18岁以下未成年不得入内")
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
