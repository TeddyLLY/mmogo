package com.smart.mmogo.dao.impl;

import com.smart.mmogo.bean.Employee;
import jakarta.annotation.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/*
 * 類似mybatis
 */
@Repository
public class MongoTemplateDAO {
    @Resource
    private MongoTemplate mongoTemplate;

    @GetMapping("findById")
    public List<Employee> find(){
        return mongoTemplate.find(new Query(),Employee.class);
    }
}
