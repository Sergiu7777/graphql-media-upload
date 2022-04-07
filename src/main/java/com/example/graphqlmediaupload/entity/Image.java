package com.example.graphqlmediaupload.entity;

import java.time.OffsetDateTime;

public class Image {
    private String uuid;
    private byte[] imageBlob;
    private int upVotes;
    private int downVotes;
    private String author;
    private OffsetDateTime uploadedAt;
}
