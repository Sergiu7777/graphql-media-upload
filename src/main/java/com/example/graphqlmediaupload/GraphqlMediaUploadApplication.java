package com.example.graphqlmediaupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
@SpringBootApplication
@EnableMongoRepositories("com.example.graphqlmediaupload.repositories")
public class GraphqlMediaUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqlMediaUploadApplication.class, args);
    }
}
