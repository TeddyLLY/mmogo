package com.smart.mmogo.dao.impl;

import com.smart.mmogo.bean.Employee;
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
    @Query(value = "{'$or':[{'first_name': ?0},{'last_name': ?1},{'job': ?2}," +
            "{'salary': ?3},{'internship': ?4},{'regular_date': ?5}]")
    List<Employee> findByField(String firstName, String lastName ,
          String job , BigDecimal salary , Boolean internship , Date regularDate );
}