package com.ssm.resume.mapper;

import com.ssm.resume.model.Resume;

import java.util.List;

public interface ResumeMapper {
    /**
     * 添加
     *
     * @param resume
     */
    void add(Resume resume);

    /**
     * 查询
     *
     * @return
     */
    List<Resume> list();

    /**
     * 更新
     *
     * @param resume
     */
    void update(Resume resume);

    /**
     * 删除
     *
     * @param id
     */
    void delete(int id);

    /**
     * 根据id获取简历
     *
     * @param id
     * @return
     */
    Resume findById(int id);
}