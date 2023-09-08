package com.smart.mmogo.dao.impl;

import com.smart.mmogo.bean.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository
        extends MongoRepository<Employee,String> {

    /*
     * 自定義Query
     */
//    @Query(value = "{'and':[{'job': ?0}]")
//    List<Employee> findByIdd(String job );

}