package com.kinghao.mango.admin.service.impl;

import com.kinghao.mango.admin.service.SysUserService;
import com.kinghao.mango.admin.dao.SysUserMapper;
import com.kinghao.mango.admin.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }
}
