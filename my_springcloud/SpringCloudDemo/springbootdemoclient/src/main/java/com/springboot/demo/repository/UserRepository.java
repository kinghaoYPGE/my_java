package com.springboot.demo.repository;


import java.util.Collection;

/**
 * spring jdbcTemplate
 */
public interface UserRepository {

    Collection findAll();
}