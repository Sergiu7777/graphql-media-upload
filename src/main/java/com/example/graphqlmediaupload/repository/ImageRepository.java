package com.example.graphqlmediaupload.repository;

import com.example.graphqlmediaupload.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {
}
