package com.smart.mmogo.dao.impl.jdbcDaoImpl;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smart.mmogo.bean.Command;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MongoDBJDBC {
    @Autowired
    static Logger logger = LoggerFactory.getLogger(MongoDBJDBC.class);

//各種連線設定方法
    public static void main(String[] args){

//            连接到MongoDB服务 with user & pwd 如果是远程连接可以替换“localhost”为服务器所在IP地址
//----------------------------------------------------------------------------------------------------------------------------------------
            //ServerAddress()两个参数分别为 服务器地址 和 端口
//            ServerAddress serverAddress = new ServerAddress("localhost",27017);
//            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
//            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
//            MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());
//            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
//            credentials.add(credential);

            //通过连接认证获取MongoDB连接
//            MongoClient mongoClient = new MongoClient(addrs,credentials);



//          simple 连接到 mongodb 服务
//----------------------------------------------------------------------------------------------------------------------------------------
//            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );



            //连接到数据库
//----------------------------------------------------------------------------------------------------------------------------------------
//            MongoDatabase mongoDatabase = mongoClient.getDatabase("employee");
//            logger.info(mongoDatabase.getName() + " Connect to database successfully");

            //doSomething logic...

    }

    public String getResult(Command command) throws Exception{

        //connect
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        MongoDatabase mongoDatabase = mongoClient.getDatabase(command.getDbName());
        logger.info(mongoDatabase.getName() + " Connect to database successfully");

        mongoDatabase.createCollection("java_test");
        MongoCollection<Document> collection = mongoDatabase.getCollection("java_test");
        logger.info("集合 java_test 选择成功");

        //插入文档
        /**
         * 1. 创建文档 org.bson.Document 参数为key-value的格式
         * 2. 创建文档集合List<Document>
         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
         * */
        Document document = new Document("title", "MongoDB").
                append("description", "database").
                append("likes", 100).
                append("by", "Fly");
        List<Document> documents = new ArrayList<Document>();
        documents.add(document);
        collection.insertMany(documents);
        logger.info("文档插入成功");

        return mongoDatabase.getName() + " operation success";

    }
}
