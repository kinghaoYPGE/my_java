package com.mymybatis.mapper;

import java.util.List;

import com.mymybatis.model.User;

public interface UserMapper {

  
  // 动态SQL条件搜索
  public User selectUserByCondition(User user) throws Exception;

  // trim 用法
  public User selectUserByConditionTrim(User user) throws Exception;
  
  // where 用法
  public User selectUserByConditionWhere(User user) throws Exception;

  // set 用法
  public int updateUserByConditionSet(User user) throws Exception;

  // foreach 用法
  public List<User> selectUsersByIdsForeach(List<Integer> ids) throws Exception;

  // bind 用法
  public List<User> selectUsersByLike(User user) throws Exception;

  
}

