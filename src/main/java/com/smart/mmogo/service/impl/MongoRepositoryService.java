package com.smart.mmogo.service.impl;

import com.smart.mmogo.bean.Employee;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.dao.impl.MongoRepositoryDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MongoRepositoryService {
    @Autowired
    MongoRepositoryDAO mongoRepositoryDAO;
    @Autowired
    static Logger logger = LoggerFactory.getLogger(MongoRepositoryService.class);

    public Page<Employee> getEmployeeList(Employee employee){
        Page<Employee> pageResult ;

        //verify
        String errMsg = employee.verify(employee) ;
        if(StringU.isNotEmpty(errMsg)){
            return null;
        }else{
            return null;
        }
    }
}
