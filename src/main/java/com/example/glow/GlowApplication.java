package com.example.glow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {"com.example.glow.repository.mongoDbRep"})
public class GlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(GlowApplication.class, args);
    }

}
