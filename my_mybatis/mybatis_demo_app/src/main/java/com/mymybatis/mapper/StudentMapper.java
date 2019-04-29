package com.mymybatis.mapper;

import java.util.List;
import com.mymybatis.model.Student;
import com.mymybatis.model.StudentCourse;

public interface StudentMapper {
    /*
     * 查询所有学生及他们的选择课程的信息
     * @return
     * @throws Exception
     */
    public List<Student> selectStudentCourse() throws Exception;

    /*
     * 删除指定id用户的某门课（根据课程id）的选课情况
     * @param StudentCourseLink
     * @throws Exception
     */
    public void deleteStudentCourseById(StudentCourse scLink) throws Exception;
}
