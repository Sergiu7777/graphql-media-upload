package com.example.graphqlmediaupload.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Builder
@Getter
@Setter
public class ImageDto {
    private String uuid;
    private int upVotes;
    private int downVotes;
    private String author;
    private String downloadLink;
    private OffsetDateTime uploadedAt;
    private String uploadedBy;
}
