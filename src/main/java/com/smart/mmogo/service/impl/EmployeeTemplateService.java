package com.smart.mmogo.service.impl;

import com.smart.mmogo.bean.Employee;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.dao.impl.EmployeeTemplateDAO;
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


    public void addEmployee(Employee employee){
        String errMsg = Employee.verify(employee);

        if(StringU.isNotEmpty(errMsg)){
            throw new RuntimeException(errMsg);
        }else{
            employeeTemplateDAO.addEmployee(employee);
        }
    }

    public Employee findById(Employee employee){
        if(StringU.isEmpty(employee.getId())){
            throw new RuntimeException("ID not found");
        }else{
            return employeeTemplateDAO.findById(employee);
        }
    }

    public void updateEmployee(Employee employee){
        String errMsg = Employee.verify(employee);

        if(StringU.isEmpty(employee.getId())){
            throw new RuntimeException("ID not found");
        }else if(StringU.isNotEmpty(errMsg)){
            throw new RuntimeException(errMsg);
        }else{
            employeeTemplateDAO.updateEmployee(employee);
        }
    }

}
