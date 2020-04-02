package com.springboot.demo.repository.es;

import com.springboot.demo.entity.es.ESBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESBlogRepository extends ElasticsearchRepository<ESBlog, Integer>{
}
