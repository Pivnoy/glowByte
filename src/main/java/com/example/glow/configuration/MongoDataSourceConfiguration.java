//package com.example.glow.configuration;
//
//
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.MongoDatabaseFactory;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//
//@Configuration
//@EnableMongoRepositories (
//        basePackages = "com.example.glow.repository.mongoDbRep",
//        mongoTemplateRef = "customMongoTemplate"
//)
//public class MongoDataSourceConfiguration {
//
//
//    @Bean(name = "mongo")
//    @ConfigurationProperties("spring.datasource-mongo")
//    public MongoProperties mongoDataSourceProperties() {
//        return new MongoProperties();
//    }
//
//    @Bean(name = "customMongoTemplate")
//    public MongoTemplate customMongoTemplate() {
//        return new MongoTemplate(mongoFactory(mongoDataSourceProperties()));
//    }
//
//    @Bean
//    public MongoDatabaseFactory mongoFactory(final MongoProperties mongoProperties)  {
//        return new SimpleMongoClientDatabaseFactory(mongoProperties.getUri());
//    }
//
//}
