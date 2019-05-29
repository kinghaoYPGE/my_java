package com.sso.service.impl;

import com.sso.service.LoginService;
import com.sso.util.EncryptUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String getTicket(String username) {
        return null;
    }

    @Override
    public String createTicket(String uuid) {
        // 通过md5摘要算法创建ticket
        String ticket = DigestUtils.md5DigestAsHex((EncryptUtil.SALT + uuid +
                System.currentTimeMillis()).getBytes());
        return ticket;
    }

    @Override
    public boolean login(String username, String password) {
        return username.equals(EncryptUtil.USERNAME)
                && password.equals(EncryptUtil.PASSWORD);
    }

    @Override
    public boolean logout(String username) {
        return false;
    }
}
