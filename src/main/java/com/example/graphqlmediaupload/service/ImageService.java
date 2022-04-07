package com.example.graphqlmediaupload.service;

import com.example.graphqlmediaupload.entity.Image;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ImageService {
    ResponseEntity<Image> saveImage(Image image);
    ResponseEntity<List<Image>> getAllImages();
}
