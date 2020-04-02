package com.springboot.demo.entity.first;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

}
