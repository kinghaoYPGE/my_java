package com.ssm.demo.service.impl;

import java.util.List;

import com.ssm.demo.mapper.UserMapper;
import com.ssm.demo.model.User;
import com.ssm.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional(rollbackFor=Exception.class)
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;

  @Override
  public User login(User user) {
    return userMapper.selectLogin(user);
  }

  @Override
  public List<User> selectAllUser() {
    return userMapper.selectAllUser();
  }

  @Override
  public void addUser(User user) {
    userMapper.addUser(user);
  }

  @Override
  public void updateUser(User user) {
    userMapper.updateUser(user);
  }

  @Override
  public void deleteUser(Integer id) {
    userMapper.deleteUser(id);
  }
}