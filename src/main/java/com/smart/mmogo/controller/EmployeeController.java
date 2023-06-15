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

import java.util.List;


/**
 * Demo with
 *  MongoRepository && MongoTemplate
 */
@RestController
public class EmployeeController {
    @Autowired
    MongoRepositoryService mongoRepositoryService;
    @Autowired
    MongoTemplateService mongoTemplateService;


    /*
     * init with select
     */
    @RequestMapping("/")
    @ResponseBody
    public ModelAndView initPage(@RequestBody(required = false) Employee employee) {
        ModelAndView mav = new ModelAndView("index");
        List<Employee> list = mongoRepositoryService.getEmployeeList(employee);

        mav.getModel().put("list", list);
        return mav;
    }

    @RequestMapping("/addEmployeePage")
    @ResponseBody
    public ModelAndView addAccount() {
        ModelAndView mav = new ModelAndView("addEmployee");
        return mav;
    }

}
