package com.smart.mmogo.dao.mongo;

import com.smart.mmogo.bean.mongo.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository
        extends MongoRepository<Employee,String> {

    /*
     * 自定義Query
     */
//    @Query(value = "{'and':[{'job': ?0}]")
//    List<Employee> findByIdd(String job );

}