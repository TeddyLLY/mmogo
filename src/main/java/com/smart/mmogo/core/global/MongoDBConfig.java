package com.smart.mmogo.core.global;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.internal.MongoClientImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
@PropertySources({
        @PropertySource("classpath:application.yml")
})
public class MongoDBConfig {
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Value("${spring.data.mongodb.authentication-database}")
    private String acDatabase;
    @Value("${spring.data.mongodb.uri}")
    private String uri;


    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate
            ( MongoDatabaseFactory mongoDBFactory, MongoMappingContext mongoMappingContext) throws Exception{

        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDBFactory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver,mongoMappingContext);

        return new MongoTemplate(mongoDBFactory,mappingConverter);
    }

    public MongoClient connectDB() throws Exception{
        MongoClient mongoClient = new MongoClientImpl(
                MongoClientSettings.builder().applyConnectionString
                        (new ConnectionString(getUri())).build(),null
        );
        return mongoClient;
    }

    public String getUri() {
        return uri;
    }

}
