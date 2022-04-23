package com.example.graphqlmediaupload.services;

import com.example.graphqlmediaupload.entity.Image;
import com.example.graphqlmediaupload.repositories.ImageRepository;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final GridFsTemplate template;
    private final GridFsOperations operations;

    public Image saveImage(DataFetchingEnvironment environment) throws IOException {
        DefaultGraphQLServletContext context = environment.getContext();
        return uploadToDB(context.getFileParts().get(0));
    }

    private Image uploadToDB(Part part) throws IOException {
        File targetFile = new File("src/main/resources/uploads/" + part.getSubmittedFileName());
        FileUtils.copyInputStreamToFile(part.getInputStream(), targetFile);

        Image image = new Image();
        image.setUploadedBy("Serghei Morari");
        image.setFileName(part.getSubmittedFileName());
        image.setFileSize(part.getSize());
        image.setContentType(part.getContentType());
//        image.setUploadedAt(OffsetDateTime.now(UTC));
        image.setDownloadLink(targetFile.getAbsolutePath());

        return imageRepository.save(image);
    }

    public Image getImageById(String id) throws IOException {
        Optional<Image> imageOptional = imageRepository.findById(id);

        if (!imageOptional.isPresent()) {
            log.info("Image not found for id: {}", id);
        }
        return imageOptional.get();
    }

    public List<Image> getImages() {
        return imageRepository.findAll();
    }
}
