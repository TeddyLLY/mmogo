package com.smart.mmogo.controller;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.bean.Employee;
import com.smart.mmogo.service.impl.MongoJDBCService;
import com.smart.mmogo.service.impl.MongoRepositoryService;
import com.smart.mmogo.service.impl.MongoTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    MongoRepositoryService mongoRepositoryService;
    @Autowired
    MongoTemplateService mongoTemplateService;


    @RequestMapping("/hello")
    @ResponseBody
    public ModelAndView hello(@RequestBody Employee employee) {
        ModelAndView mav = new ModelAndView("index");
        Page<Employee> pageResult = mongoRepositoryService.getEmployeeList(employee);

        mav.getModel().put("page", pageResult);
        return mav;
    }

    @RequestMapping("/addEmployeePage")
    @ResponseBody
    public ModelAndView addAccount() {
        ModelAndView mav = new ModelAndView("addEmployee");
        return mav;
    }

}
