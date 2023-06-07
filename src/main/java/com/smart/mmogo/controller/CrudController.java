package com.smart.mmogo.controller;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.service.impl.CrudService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



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
    public String getApiDoc() {
        return "MongoDB Demo 系統";
    }


    @RequestMapping("/jdbcCrud")
    @ResponseBody
    public String jdbcCrud(HttpServletRequest req, HttpServletResponse res , Command command) {
        String script = req.getParameter("script");

        //script vaild
        if(StringU.isEmpty(command.getDbName()) || StringU.isEmpty(command.getType()) ){
            return "please enter command";
        }

        try {
            return crudService.getResult(command);
        }catch (Exception e) {
            return "exception happened !! \n"+ e ;
        }
    }
}
