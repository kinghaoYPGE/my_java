package com.springboot.demo.service;

/**
 * 登陆接口
 */
public interface LoginService {
    /**
     * 通过用户名得到登陆票据
     * @param username
     * @return
     */
    String getTicket(String username);

    /**
     * 通过uuid随机创建票据
     * @param uuid
     * @return
     */
    String createTicket(String uuid);

    /**
     * 用户名密码登陆
     * @param username
     * @return ture:登陆成功
     */
    boolean login(String username, String password);

    /**
     * 用户登出
     * @param username
     * @return
     */
    boolean logout(String username);
}
