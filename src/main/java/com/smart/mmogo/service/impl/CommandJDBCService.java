package com.smart.mmogo.service.impl;

import com.smart.mmogo.bean.Command;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.dao.impl.CommandJDBCDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommandJDBCService {

    @Autowired
    CommandJDBCDAO commandJDBCDAO;
    @Autowired
    static Logger logger = LoggerFactory.getLogger(CommandJDBCService.class);

    public String getResultByCommand(Command command){

        //verify
        String errMsg = command.verify(command) ;
        if(StringU.isNotEmpty(errMsg)){
            return errMsg;
        }

        //business logic
        try {
            return commandJDBCDAO.getResultByCommand(command);

        }catch (Exception e){
            logger.error("exception happened !! \n"+e.getMessage(),e);

            //transaction
            throw new RuntimeException
                    ("系統異常 ！ 請重新操作並確認參數或聯繫管理員 ！！");
        }
    }

}
