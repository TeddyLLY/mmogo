package com.smart.mmogo.core.global;

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
    @Value("${spring.data.mongodb.host}")
    private String host;
    @Value("${spring.data.mongodb.port}")
    private Integer port;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String password;

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate
            ( MongoDatabaseFactory mongoDBFactory, MongoMappingContext mongoMappingContext) throws Exception{

        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDBFactory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver,mongoMappingContext);

        return new MongoTemplate(mongoDBFactory,mappingConverter);
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getAcDatabase() {
        return acDatabase;
    }

    public void setAcDatabase(String acDatabase) {
        this.acDatabase = acDatabase;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
