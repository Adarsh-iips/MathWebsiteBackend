package com.example.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        basePackages = "com.example.backend.repository",
        mongoTemplateRef = "mathForgeMongoTemplate"
)
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Primary
    @Bean
    public MongoDatabaseFactory mathForgeFactory() {

        return new SimpleMongoClientDatabaseFactory(
                mongoUri
        );
    }

    @Primary
    @Bean
    public MongoTemplate mathForgeMongoTemplate() {

        return new MongoTemplate(
                mathForgeFactory()
        );
    }
}