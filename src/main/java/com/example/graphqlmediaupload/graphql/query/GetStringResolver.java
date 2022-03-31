package com.example.graphqlmediaupload.graphql.query;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class GetStringResolver implements GraphQLQueryResolver {

    public String getString() {
        return "Hello world!!!";
    }
}
