package com.springboot.demo.repository.impl;

import com.springboot.demo.entity.User;
import com.springboot.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<User> findAll() {
        return jdbcTemplate.query("select id, name, age from t_user", new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject("select * from t_user where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update("update t_user set name=? where id=?", user.getName(), user.getId());
    }

    @Override
    public int save(User user) {
        return jdbcTemplate.update("insert into t_user(id, name, age) values(?,?,?)", user.getId(), user.getName(), user.getAge());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("delete from t_user where id=?", id);
    }
}
