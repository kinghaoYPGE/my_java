package com.kinghao.mango.core.service;

import com.kinghao.mango.core.page.PageResult;

import java.util.List;

/**
 * 通用CRUD操作接口
 */
public interface CrudService<T> {

    /**
     * 保存
     * @param record
     * @return
     */
    int save(T record);

    /**
     * 删除
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 批量删除
     * @param records
     * @return
     */
    int delete(List<T> records);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 分页查询
     * @param pageResult
     * @return
     */
    PageResult findPage(PageResult pageResult);

}
