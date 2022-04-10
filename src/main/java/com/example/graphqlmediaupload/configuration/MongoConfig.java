package com.example.graphqlmediaupload.configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.example.graphqlmediaupload.repository")
@AllArgsConstructor
@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
    private final MappingMongoConverter mongoConverter;

    @Bean
    public GridFsTemplate gridFsTemplate() throws Exception {
        return new GridFsTemplate(mongoDbFactory(), mongoConverter);
    }

    @Override
    protected String getDatabaseName() {
        return null;
    }
}
