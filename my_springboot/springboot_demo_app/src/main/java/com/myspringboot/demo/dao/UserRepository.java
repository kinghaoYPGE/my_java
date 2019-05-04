package com.myspringboot.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.myspringboot.demo.model.User;

/**
 * 继承CrudRepository
 */
public interface UserRepository extends CrudRepository<User, Integer> {

}