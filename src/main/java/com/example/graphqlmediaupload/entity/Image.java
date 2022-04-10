package com.example.graphqlmediaupload.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.OffsetDateTime;

@Getter
@Setter
@Document(collection = "images")
public class Image {
    private String uuid;
    private byte[] imageBlob;
    private int upVotes;
    private int downVotes;
    private String author;
    private String downloadLink;
    private OffsetDateTime uploadedAt;
    private String uploadedBy;
}
