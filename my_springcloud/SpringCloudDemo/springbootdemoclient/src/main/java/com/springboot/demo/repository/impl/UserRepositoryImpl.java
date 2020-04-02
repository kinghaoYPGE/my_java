package com.springboot.demo.repository.impl;

import com.springboot.demo.repository.UserRepository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserRepositoryImpl
        extends JdbcDaoSupport implements UserRepository {


    @Override
    public Collection findAll() {
        return null;
    }
}
