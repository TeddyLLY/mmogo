package com.smart.mmogo.dao.impl;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.smart.mmogo.bean.Command;
import com.smart.mmogo.core.utils.XsonU;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

        switch (command.getType()){
            case "delete":
                return  delete( mongoDatabase , command);

            case "select":
                return  select( mongoDatabase , command);

            case "update":
                return  update( mongoDatabase , command);

            case "insert":
                return  insert( mongoDatabase , command);

            case "base":
                return  base( mongoDatabase , command);

            default:
                throw new RuntimeException("no optional type") ;

        }

    }

    public String delete( MongoDatabase mongoDatabase , Command command){
        return "";
    }

    public String select( MongoDatabase mongoDatabase , Command command){
        return "";
    }

    public String update( MongoDatabase mongoDatabase , Command command){
        return "";
    }

    public String insert( MongoDatabase mongoDatabase , Command command){
        //chose collection
        MongoCollection<Document> collection = mongoDatabase.getCollection(command.getCollection());
        logger.info("集合 "+command.getCollection()+" 选择成功");

        //插入文档
        /**
         * 1. 创建文档 org.bson.Document 参数为key-value的格式
         * 2. 创建文档集合List<Document>
         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
         * */
        List<Document> documents = XsonU.covertDocuments(command);
        collection.insertMany(documents);
        logger.info("documents insert success");

        return mongoDatabase.getName() + " operation success";
    }

    public String base( MongoDatabase mongoDatabase , Command command){
        return "";
    }
}
