package com.smart.mmogo.service.impl;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.dao.impl.jdbcDaoImpl.MongoDBJDBC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService {

    @Autowired
    MongoDBJDBC mongoDBJDBC;
    @Autowired
    static Logger logger = LoggerFactory.getLogger(CrudService.class);

    public String getResult(Command command){

        try {
            return mongoDBJDBC.getResult(command);

        }catch (Exception e){
            logger.error("exception happened !! \n"+e.getMessage(),e);

            //transaction
            throw new RuntimeException(e);
        }
    }


}
