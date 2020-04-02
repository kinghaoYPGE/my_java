package com.springboot.demo.repository.mysql;

import com.springboot.demo.entity.mysql.Blog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog, Integer> {

    @Query("select e from Blog e order by e.createTime desc ")
    List<Blog> quaryAll();

    @Query("select e from Blog e where e.title " +
            "like concat('%', :keyword, '%') " +
            "or e.content like concat('%', :keyword, '%')")
    List<Blog> queryBlogs(@Param("keyword") String keyword);

}
