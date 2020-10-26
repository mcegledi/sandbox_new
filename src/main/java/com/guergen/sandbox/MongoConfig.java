package com.guergen.sandbox;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.guergen.sandbox.repositories.mongodb")
public class MongoConfig {
}
