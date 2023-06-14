package com.smart.mmogo.controller;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.service.impl.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class EmployeeController {
    @Autowired
    CrudService crudService;


    @RequestMapping("/hello")
    @ResponseBody
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @RequestMapping("/addEmployeePage")
    @ResponseBody
    public ModelAndView addAccount() {
        ModelAndView mav = new ModelAndView("addEmployee");
        return mav;
    }

}
