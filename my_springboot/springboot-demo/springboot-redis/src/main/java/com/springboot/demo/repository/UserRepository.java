package com.springboot.demo.repository;

import com.springboot.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserRepository {

    @Resource
    private RedisTemplate<String, User> redisTemplate;

    public User get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, User user) {
        redisTemplate.opsForValue().set(key, user);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

}
