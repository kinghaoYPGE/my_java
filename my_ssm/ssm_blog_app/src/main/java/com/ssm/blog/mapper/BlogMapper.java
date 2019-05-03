package com.ssm.blog.mapper;

import java.util.List;

import com.ssm.blog.model.Blog;

public interface BlogMapper {
  void writeBlog(Blog blog);

  List<Blog> selectAllBlog();

  List<Blog> selectBlogById(int blogid);

  void deleteBlogById(int blogid);
  
}