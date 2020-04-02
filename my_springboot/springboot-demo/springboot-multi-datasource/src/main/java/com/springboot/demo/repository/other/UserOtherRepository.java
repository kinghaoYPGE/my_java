package com.springboot.demo.repository.other;

import com.springboot.demo.entity.first.User;
import com.springboot.demo.entity.other.UserOther;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOtherRepository extends JpaRepository<UserOther, Long> {

}
