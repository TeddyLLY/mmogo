package com.smart.mmogo.dao.mongo;

import com.smart.mmogo.bean.mongo.Employee;
import com.smart.mmogo.core.utils.StringU;
import jakarta.annotation.Resource;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * 類似mybatis
 */
@Repository
public class EmployeeTemplateDAO {
    @Resource
    private MongoTemplate mongoTemplate;

    public void addEmployee(Employee employee){
        mongoTemplate.insert(employee);
    }


    public Employee findById(Employee employee){
        ObjectId id = new ObjectId(employee.getId());
        return mongoTemplate.findById(id ,Employee.class);
    }


    public void updateEmployee(Employee employee){
        Query query = new Query(Criteria.where("_id").is(new ObjectId(employee.getId())));
        List<Employee> existingEmployees = mongoTemplate.find(query, Employee.class);

        if (StringU.isNotEmpty(existingEmployees) && existingEmployees.size()==1) {
            mongoTemplate.save(employee);
        }else{
            if(StringU.isEmpty(existingEmployees) || existingEmployees.size()==0){
                throw new RuntimeException("value not found!");
            }else {
                throw new RuntimeException("Duplicate value!");
            }
        }
    }


}
