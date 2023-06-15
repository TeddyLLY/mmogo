package com.smart.mmogo.controller;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.service.impl.MongoJDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Demo with MongoDB JDBC
 */
@RestController
public class CrudController {

    @Autowired
    MongoJDBCService mongoJDBCService;

    @RequestMapping("/crud")
    @ResponseBody
    public String JsonJdbcCrud(@RequestBody Command command) {

            return mongoJDBCService.getResultByCommand(command);
    }
}
