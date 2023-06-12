package com.smart.mmogo.controller;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.service.impl.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author teddy
 */
@RestController
public class CrudController {

    @Autowired
    CrudService crudService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/")
    @ResponseBody
    public ModelAndView indexPage() {

        ModelAndView mav = new ModelAndView("redirect:/index");
        return mav;
    }


    @RequestMapping("/crud")
    @ResponseBody
    public String JsonJdbcCrud(@RequestBody Command command) {

            return crudService.getResultByCommand(command);

    }
}
