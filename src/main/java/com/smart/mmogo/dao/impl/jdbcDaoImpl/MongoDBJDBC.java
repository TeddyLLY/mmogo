package com.smart.mmogo.dao.impl.jdbcDaoImpl;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public String getResult(String script) throws Exception{

            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            MongoDatabase mongoDatabase = mongoClient.getDatabase("employee");

            logger.info(mongoDatabase.getName() + " Connect to database successfully");
            return mongoDatabase.getName() + " Connect to database successfully";

    }
}
