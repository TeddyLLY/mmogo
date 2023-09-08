package com.smart.mmogo.controller;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.service.impl.CommandJDBCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * MongoDB JDBC
 * Demo with Postman collection data
 */
@RestController
public class CommandController {

    @Autowired
    CommandJDBCService commandJDBCService;

    @RequestMapping("/crud")
    @ResponseBody
    public String JsonJdbcCrud(@RequestBody Command command) {

            return commandJDBCService.getResultByCommand(command);
    }
}
