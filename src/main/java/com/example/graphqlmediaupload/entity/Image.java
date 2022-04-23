package com.example.graphqlmediaupload.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@Getter
@Setter
@Document(collection = "images")
public class Image {
    private String id;
    private String fileName;
    private Long fileSize;
    private String contentType;
    private String downloadLink;

//    private OffsetDateTime uploadedAt;
    private String uploadedBy;
    private int upVotes;
    private int downVotes;
}
