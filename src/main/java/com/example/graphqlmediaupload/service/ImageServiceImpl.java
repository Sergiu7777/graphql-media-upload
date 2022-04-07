package com.example.graphqlmediaupload.service;

import com.example.graphqlmediaupload.entity.Image;
import com.example.graphqlmediaupload.repository.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ResponseEntity<Image> saveImage(Image image) {
        imageRepository.save(image);
        return ResponseEntity.of(Optional.of(image));
    }

    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageRepository.findAll();
        return ResponseEntity.of(Optional.of(images));
    }
}
