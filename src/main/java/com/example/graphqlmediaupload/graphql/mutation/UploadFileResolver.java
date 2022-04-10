package com.example.graphqlmediaupload.graphql.mutation;

import com.example.graphqlmediaupload.entity.Image;
import com.example.graphqlmediaupload.service.ImageService;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Component
public class UploadFileResolver implements GraphQLMutationResolver {
    private final ImageService imageService;

    public UUID uploadFile(DataFetchingEnvironment environment) {
        DefaultGraphQLServletContext context =  environment.getContext();
        context.getFileParts().forEach(part -> {
            save(part, part.getSubmittedFileName());
        });

        return UUID.randomUUID();
    }

    //TODO: move to services
    private void save(Part part, String fileName) {
        Image image = new Image();

        try(InputStream inputStream = part.getInputStream()) {
            imageService.saveImage(image, inputStream);
        } catch (IOException e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}
