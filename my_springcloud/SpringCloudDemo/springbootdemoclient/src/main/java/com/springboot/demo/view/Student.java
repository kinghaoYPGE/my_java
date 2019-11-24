package com.springboot.demo.view;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Student {
    @NotNull(message="id不能为空")
    private long id;
    @NotEmpty(message="name不能为空")
    @Length(min=2, message="name不能小于2位长度")
    private String name;
    @Min(value=18, message = "年龄必须大于18岁")
    private int age;
}
