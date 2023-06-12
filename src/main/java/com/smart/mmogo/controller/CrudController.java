package com.smart.mmogo.controller;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.service.impl.CrudService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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



    @RequestMapping("/crud")
    @ResponseBody
    @Deprecated
    public String jdbcCrud(HttpServletRequest req, HttpServletResponse res , Command command) {
//        String script = req.getParameter("script");

        return crudService.getResult(command);

    }

    @RequestMapping("/jsonCrud")
    @ResponseBody
    public String JsonJdbcCrud(@RequestBody Command command) {

            return crudService.getResult(command);

    }
}
