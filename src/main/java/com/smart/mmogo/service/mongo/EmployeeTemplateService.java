package com.smart.mmogo.service.mongo;

import com.smart.mmogo.bean.mongo.Employee;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.dao.mongo.EmployeeTemplateDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTemplateService {
    @Autowired
    EmployeeTemplateDAO employeeTemplateDAO;
    @Autowired
    static Logger logger = LoggerFactory.getLogger(EmployeeTemplateService.class);


    public void post(Employee employee){
        String errMsg = Employee.verify(employee);

        if(StringU.isNotEmpty(errMsg)){
            throw new RuntimeException(errMsg);
        }else{
            employeeTemplateDAO.post(employee);
        }
    }

    public Employee get(Employee employee){
        if(StringU.isEmpty(employee.getId())){
            throw new RuntimeException("ID not found");
        }else{
            return employeeTemplateDAO.get(employee.getId());
        }
    }

    public void put(Employee employee){
        String errMsg = Employee.verify(employee);

        if(StringU.isEmpty(employee.getId())){
            throw new RuntimeException("ID not found");
        }else if(StringU.isNotEmpty(errMsg)){
            throw new RuntimeException(errMsg);
        }else{
            employeeTemplateDAO.put(employee);
        }
    }

}
