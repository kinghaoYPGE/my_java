package com.springboot.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "t_user")
@Entity
public class User implements Serializable{
    @Id
    private Long id;
    private String name;
    private Integer age;
}
