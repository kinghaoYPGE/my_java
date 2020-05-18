package com.kinghao.mango.admin.service;

import com.kinghao.mango.admin.model.SysUser;

import java.util.List;

/**
 * 查询所有用户
 */
public interface SysUserService {

    List<SysUser> findAll();

}
