package com.kinghao.mango.admin.dao;

import com.kinghao.mango.admin.model.SysLog;
import java.util.List;

public interface SysLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated
     */
    int insert(SysLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated
     */
    SysLog selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated
     */
    List<SysLog> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SysLog record);
}