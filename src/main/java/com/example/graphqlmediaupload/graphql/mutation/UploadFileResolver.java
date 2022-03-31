package com.example.graphqlmediaupload.graphql.mutation;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Slf4j
@Component
public class UploadFileResolver implements GraphQLMutationResolver {

    public UUID uploadFile(DataFetchingEnvironment environment) {
        DefaultGraphQLServletContext context =  environment.getContext();
        context.getFileParts().forEach(part -> {
            save(part, part.getSubmittedFileName());
        });

        return UUID.randomUUID();
    }

    private void save(Part part, String fileName) {
        try(InputStream inputStream = part.getInputStream()) {
            File file = new File("/resources/uploads/" + fileName);
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}
