package com.springboot.demo.entity.other;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class UserOther {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

}
