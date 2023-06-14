package com.smart.mmogo.service.impl;

import com.smart.mmogo.dao.impl.MongoTemplateDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoTemplateService {
    @Autowired
    MongoTemplateDAO mongoTemplateDAO;
    @Autowired
    static Logger logger = LoggerFactory.getLogger(MongoTemplateService.class);


}
