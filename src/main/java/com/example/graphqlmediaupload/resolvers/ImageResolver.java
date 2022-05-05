package com.example.graphqlmediaupload.resolvers;

import com.example.graphqlmediaupload.entity.Image;
import com.example.graphqlmediaupload.services.ImageService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class ImageResolver implements GraphQLMutationResolver, GraphQLQueryResolver {
    private final ImageService imageService;

    public ResponseEntity<?> uploadFile(DataFetchingEnvironment environment) throws IOException {
        return new ResponseEntity<>(imageService.saveImage(environment), HttpStatus.OK);
    }

    public Image getImageById(String fileId) throws IOException {
        return imageService.getImageById(fileId);
    }

    public List<Image> getImages() {
        return imageService.getImages();
    }
}
