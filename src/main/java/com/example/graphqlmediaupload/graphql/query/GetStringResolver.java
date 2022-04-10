package com.example.graphqlmediaupload.graphql.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GetStringResolver implements GraphQLQueryResolver {

    public String getString() {
        log.info("Query getString");
        return "Hello world!!!";
    }

    public ResponseEntity<String> getImages() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
