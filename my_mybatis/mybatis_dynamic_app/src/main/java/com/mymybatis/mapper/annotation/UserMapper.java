package com.mymybatis.mapper.annotation;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mymybatis.model.User;

public interface UserMapper {

    /*
     * 新增用户
     * @param user
     * @return
     * @throws Exception
     */
    @Insert("insert into user(username,password,sex,age,phone,address) values(#{username},#{password},#{sex},#{age},#{phone},#{address})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    public int insertUser(User user) throws Exception;

    /*
     * 更新用户
     * @param user
     * @throws Exception
     */
    @Update("update user set age=#{age} where id=#{id}")
    public void updateUser(User user) throws Exception;

    /*
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    @Delete("delete from user where id=#{user_id}")
    public int deleteUser(@Param("user_id") Integer id) throws Exception;

    /*
     * id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from user where id=#{id}")
    @Results({
        // @Result(id=true,property="id",column="id"),
        @Result(property="username",column="username"),
        @Result(property="password",column="password"),
        @Result(property="sex",column="sex"),
        @Result(property="age",column="age"),
        @Result(property="phone",column="phone"),
        @Result(property="address",column="address")
    })
    public User selectUserById(Integer id) throws Exception;

    /*
     * 查询所有用户
     * @return
     * @throws Exception
     */
    @Select("select * from user")
    public List<User> selectAllUser() throws Exception;
}
