package com.mymybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mymybatis.mapper.UserMapper;
import com.mymybatis.model.User;

public class App {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        // Mybatis 配置文件
        String resource = "mybatis.cfg.xml";

        // 得到配置文件流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 创建会话工厂，传入 MyBatis 的配置文件信息
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // selectUserByCondition();
        updateUserByConditionSet();

    }

    // 动态条件搜索用户信息
    private static void selectUserByCondition() {

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            User condition = new User();
            condition.setAddress("chengdu");
            User user = mapper.selectUserByCondition(condition);
            session.commit();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }

    // 更新用戶
    private static void updateUserByConditionSet() {

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setAddress("chongqing");
        try {
            mapper.updateUserByConditionSet(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }

    

    // 查询所有的用户信息
    /*private static void selectAllUser() {

        SqlSession session = sqlSessionFactory.openSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            List<User> userList = mapper.selectAllUser();
            session.commit();
            for (User user : userList) {
                System.out.println(user.getId() + " " + user.getUsername() + " "
                        + user.getPassword() + " " + user.getSex() + " "
                        + user.getAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

        session.close();
    }*/
}