package com.springboot.demo.repository.first;

import com.springboot.demo.entity.first.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
