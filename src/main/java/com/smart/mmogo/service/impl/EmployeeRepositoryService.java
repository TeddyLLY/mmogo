package com.smart.mmogo.service.impl;

import com.smart.mmogo.bean.Employee;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.dao.impl.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRepositoryService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    static Logger logger = LoggerFactory.getLogger(EmployeeRepositoryService.class);

    public List<Employee> getEmployeeList(Employee employee){

        if(StringU.isEmpty(employee)){
            return employeeRepository.findAll();
        }else {
            Example example = Example.of(employee,stringContainMacher());
            return employeeRepository.findAll(example);
        }
    }

    private ExampleMatcher stringContainMacher(){
        return ExampleMatcher.matching()
                //Spring Data中使用MongoDB时，插入数据会添加一个_class字段，这个字段是用来映射POJO的
                //查詢預設有_class , 要查ＤＢ直接塞的資料要忽略 _class
                .withIgnorePaths("_class")//要忽略的屬性
                .withMatcher("id",matcher -> matcher.exact())//id精確查詢
                .withMatcher("salary",matcher -> matcher.exact())//id精確查詢
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)//其他模糊查詢
                .withIgnoreNullValues();
    }

    public void deleteEmployee(Employee employee){
        employeeRepository.deleteById(employee.getId());
    }

}
