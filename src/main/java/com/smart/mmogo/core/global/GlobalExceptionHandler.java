package com.smart.mmogo.core.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * @RestControllerAdvice
     * 全域 handle exception.
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String processException(Exception e) {
        logger.error(e.getLocalizedMessage(), e);
        // 詳細錯誤訊息 不顯示於用戶端
        return "GlobalExceptionHandler Exception happened !! \n" + e.getMessage();
    }
}
