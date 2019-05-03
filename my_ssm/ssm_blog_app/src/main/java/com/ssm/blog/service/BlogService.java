package com.ssm.blog.service;

import java.util.List;

import com.ssm.blog.model.Blog;

public interface BlogService {

    void writeBlog(Blog blog);

    List<Blog> selectAllBlog();

    List<Blog> selectBlogById(int blogid);

    void deleteBlogById(int blogid);

}
