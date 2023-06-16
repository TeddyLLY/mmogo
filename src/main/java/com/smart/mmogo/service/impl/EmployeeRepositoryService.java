package com.smart.mmogo.service.impl;

import com.smart.mmogo.bean.Employee;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.dao.impl.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
            return employeeRepository.findByField(employee.getFirstName(),
                    employee.getLastName(),employee.getJob(),employee.getSalary(),
                    employee.getInternship(),employee.getRegularDate());
        }
    }

    public void deleteEmployee(Employee employee){
        employeeRepository.deleteById(employee.getId());
    }

}
