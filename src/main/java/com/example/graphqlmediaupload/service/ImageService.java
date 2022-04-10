package com.example.graphqlmediaupload.service;

import com.example.graphqlmediaupload.entity.Image;
import org.springframework.http.ResponseEntity;

import java.io.InputStream;
import java.util.List;

public interface ImageService {
    ResponseEntity<Image> saveImage(Image image, InputStream inputStream);
    ResponseEntity<List<Image>> getAllImages();
}
