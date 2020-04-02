package com.springboot.demo.controller;

import com.springboot.demo.entity.Param;
import com.springboot.demo.entity.es.ESBlog;
import com.springboot.demo.entity.mysql.Blog;
import com.springboot.demo.repository.es.ESBlogRepository;
import com.springboot.demo.repository.mysql.BlogRepository;
import org.elasticsearch.common.StopWatch;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogHandler {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ESBlogRepository esBlogRepository;


    @GetMapping("/list")
    public Object list() {
        return blogRepository.quaryAll();
    }

    @PostMapping("/search")
    public Object search(@RequestBody Param param) {
        HashMap<String, Object> result = new HashMap<>();
        StopWatch watch = new StopWatch();
        watch.start();
        String type = param.getType();
        switch (type) {
            case "mysql":
                List<Blog> blogs = blogRepository.queryBlogs(param.getKeyword());
                result.put("list", blogs);
                break;
            case "es":
                BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
                queryBuilder.should(
                        QueryBuilders.matchPhraseQuery("title", param.getKeyword())
                ).should(
                        QueryBuilders.matchPhraseQuery("content", param.getKeyword())
                );
                String esQuery = queryBuilder.toString();
                System.out.println(esQuery);
                Page<ESBlog> search = (Page<ESBlog>) esBlogRepository.search(queryBuilder);
                List<ESBlog> content = search.getContent();
                result.put("list", content);
                break;
            default:
                return null;
        }
        watch.stop();
        long millis = watch.totalTime().getMillis();
        result.put("duration", millis);
        return result;
    }

}
