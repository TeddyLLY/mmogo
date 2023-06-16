package com.smart.mmogo.controller;

import com.google.gson.Gson;
import com.smart.mmogo.bean.Employee;
import com.smart.mmogo.core.constant.CommonConst;
import com.smart.mmogo.service.impl.EmployeeRepositoryService;
import com.smart.mmogo.service.impl.EmployeeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Demo with
 *  MongoRepository && MongoTemplate
 */
@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepositoryService employeeRepositoryService;
    @Autowired
    EmployeeTemplateService employeeTemplateService;


    /*
     * init with select
     */
    @RequestMapping("/")
    @ResponseBody
    public ModelAndView initPage(@RequestBody(required = false) Employee employee) {
        ModelAndView mav = new ModelAndView("index");
        List<Employee> list = employeeRepositoryService.getEmployeeList(employee);

        mav.getModel().put("list", list);
        return mav;
    }

    @RequestMapping("/addEmployeePage")
    @ResponseBody
    public ModelAndView addEmployeePage() {
        ModelAndView mav = new ModelAndView("addEmployee");
        return mav;
    }

    @RequestMapping("/addEmployee")
    @ResponseBody
    public void addEmployee(@RequestBody Employee employee) {
        employeeTemplateService.addEmployee(employee);
    }

    @RequestMapping("/updateEmployeePage")
    @ResponseBody
    public ModelAndView updateEmployeePage(@RequestParam("data") String employeeJson) throws Exception{
        // Decode the URL-encoded JSON string
        String decodedJson = java.net.URLDecoder.decode(employeeJson, "UTF-8");
        // Parse the JSON string into a Java object
        // Assuming you have a corresponding Employee class
        Employee paramVO = new Gson().fromJson(decodedJson, Employee.class);

        //find by id
        Employee employee = employeeTemplateService.findById(paramVO);

        ModelAndView mav = new ModelAndView("updateEmployee");
        mav.getModel().put("employee", employee);
        return mav;
    }

    @RequestMapping("/updateEmployee")
    @ResponseBody
    public Integer updateEmployee(@RequestBody Employee employee) {
        employeeTemplateService.updateEmployee(employee);
        return CommonConst.STATUS_ON;
    }

    @RequestMapping("/deleteEmployee")
    @ResponseBody
    public Integer deleteEmployee(@RequestBody Employee employee) throws Exception{
        //delete by id
        employeeRepositoryService.deleteEmployee(employee);
        return CommonConst.STATUS_ON;
    }

}
