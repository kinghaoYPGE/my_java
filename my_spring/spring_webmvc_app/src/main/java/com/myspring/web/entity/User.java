package com.myspring.web.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotBlank(message = "Username can not be empty")
    private String username;
    @NotBlank(message = "password can not be blank")
    @Length(min = 6, max = 16, message = "The length of the password must be between 6 and 16 bits")
    private String password;
    @Range(min = 18, max = 60, message = "Age must be between 18 and 60 years old")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}