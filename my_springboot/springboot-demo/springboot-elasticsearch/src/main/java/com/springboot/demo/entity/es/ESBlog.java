package com.springboot.demo.entity.es;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "blog",
        type = "_doc",
        useServerConfiguration = true,
        createIndex = false)
public class ESBlog {
    @Id
    private Integer id;
    @Field(type = FieldType.Keyword, analyzer = "ik_smart")
    private String title;
    @Field(type = FieldType.Keyword, analyzer = "ik_smart")
    private String author;
    @Field(type = FieldType.Keyword, analyzer = "ik_smart")
    private String content;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
