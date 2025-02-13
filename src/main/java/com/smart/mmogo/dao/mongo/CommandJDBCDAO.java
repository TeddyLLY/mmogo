package com.smart.mmogo.dao.mongo;


import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.internal.MongoClientImpl;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.smart.mmogo.bean.mongo.Command;
import com.smart.mmogo.core.global.MongoDBConfig;
import com.smart.mmogo.core.utils.StringU;
import com.smart.mmogo.core.utils.XsonU;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.smart.mmogo.core.utils.XsonU.covertJson;

/**
 * @author teddylai
 */
@Repository
public class CommandJDBCDAO {
    @Autowired
    static Logger logger = LoggerFactory.getLogger(CommandJDBCDAO.class);
    @Autowired
    MongoDBConfig mongoDBConfig;




    public String getResultByCommand(Command command) throws Exception{

        //connect
        MongoClient mongoClient = connectDB();
        
        try {
            MongoDatabase mongoDatabase = mongoClient.getDatabase(command.getDbName());
            logger.info(mongoDatabase.getName() + " Connect to database successfully");

            //chose collection
            MongoCollection<Document> collection = mongoDatabase.getCollection(command.getCollection());
            logger.info("集合 "+command.getCollection()+" 选择成功");

            switch (command.getType()){
                case "insert":
                    return  insert( mongoDatabase , collection , command);

                case "select":
                    return  select( mongoDatabase , collection  , command);

                case "update":
                    return  update( mongoDatabase , collection  , command);

                case "delete":
                    return  delete( mongoDatabase , collection  , command);

                default:
                    throw new RuntimeException("no optional type") ;
            }

        }catch (Exception e) {
            throw new RuntimeException(e);

        }finally {
            mongoClient.close();
        }

    }

    private MongoClient connectDB() throws Exception{
        MongoClient mongoClient = new MongoClientImpl(
                MongoClientSettings.builder().applyConnectionString
                        (new ConnectionString(mongoDBConfig.getUri())).build(),null
        );
        return mongoClient;
    }


    public String insert(MongoDatabase mongoDatabase , MongoCollection<Document> collection, Command command){

        //插入文档
        /**
         * 1. 创建文档 org.bson.Document 参数为key-value的格式
         * 2. 创建文档集合List<Document>
         * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document)
         * */
        List<Document> documents = XsonU.covertDocuments(command);
        collection.insertMany(documents);
        logger.info("documents insert success");

        return mongoDatabase.getName() + " insert operate success";
    }

    public String delete( MongoDatabase mongoDatabase , MongoCollection<Document> collection , Command command){

        Document filter =  covertJson(command.getFilter()) ;
        //删除符合条件的第一个文档
//        collection.deleteOne(Filters.eq(command.getFilter());
        //删除所有符合条件的文档
        DeleteResult result = collection.deleteMany(filter);

        return "Deleted document count : \n" + result.getDeletedCount() ;

    }

    public String select( MongoDatabase mongoDatabase , MongoCollection<Document> collection, Command command){
        Document filter = XsonU.covertJson(command.getFilter());

        //检索所有文档
        /**
         * 1. 获取迭代器FindIterable<Document>
         * 2. 获取游标MongoCursor<Document>
         * 3. 通过游标遍历检索出的文档集合
         * */
        FindIterable<Document> findIterable = collection.find(filter);
        MongoCursor<Document> mongoCursor = findIterable.iterator();

        StringBuilder result = new StringBuilder();
        while(mongoCursor.hasNext()){
            result.append(mongoCursor.next()+"\n");
        }
        if(StringU.isEmpty(result)){
            return "data not found";
        }else{
            return result.toString() ;
        }

    }

    public String update( MongoDatabase mongoDatabase , MongoCollection<Document> collection, Command command){

        if(StringU.isEmpty(command.getFilter())||StringU.isEmpty(command.getUpdate())
                ||StringU.isEmpty(command.getUpsert())){
            return "please enter update command !";
        }

        Document filter = covertJson(command.getFilter()) ;
        Document update = covertJson(command.getUpdate()) ;
        UpdateOptions options = new UpdateOptions();
        options.upsert(command.getUpsert());
        collection.updateMany(filter,update,options);

        return mongoDatabase.getName() + " update operate success";
    }

}
