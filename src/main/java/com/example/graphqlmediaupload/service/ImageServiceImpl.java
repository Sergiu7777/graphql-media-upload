package com.example.graphqlmediaupload.service;

import com.example.graphqlmediaupload.entity.Image;
import com.example.graphqlmediaupload.repository.ImageRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final GridFsTemplate gridFsTemplate;

    public ResponseEntity<Image> saveImage(Image image, InputStream inputStream) {
        DBObject metaData = new BasicDBObject();
        gridFsTemplate.store(inputStream, "test.png", "image/png", metaData).toString();

        imageRepository.save(image);
        return ResponseEntity.of(Optional.of(image));
    }

    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageRepository.findAll();
        return ResponseEntity.of(Optional.of(images));
    }
}
