package com.smart.mmogo.service.impl;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.dao.impl.MongoJDBC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService {

    @Autowired
    MongoJDBC mongoDBJDBC;
    @Autowired
    static Logger logger = LoggerFactory.getLogger(CrudService.class);

    public String getResultByCommand(Command command){

        //verify
        String errMsg = verify(command) ;
        if(StringU.isNotEmpty(errMsg)){
            return errMsg;
        }

        //business logic
        try {
            return mongoDBJDBC.getResultByCommand(command);

        }catch (Exception e){
            logger.error("exception happened !! \n"+e.getMessage(),e);

            //transaction
            throw new RuntimeException
                    ("系統異常 ！ 請重新操作並確認參數或聯繫管理員 ！！");
        }
    }

    //script verify
    public String verify(Command command){
        //base verify
        if(StringU.isEmpty(command.getDbName()) || StringU.isEmpty(command.getCollection()) || StringU.isEmpty(command.getType()) ){
            return "please set operate message!";
        }else if( StringU.isEmpty(command.getDocuments()) && StringU.isEmpty(command.getFilter())
                && StringU.isEmpty(command.getUpsert()) &&  StringU.isEmpty(command.getUpdate())){
            return "please enter command!";
        }else{
            return "";
        }
    }


}
