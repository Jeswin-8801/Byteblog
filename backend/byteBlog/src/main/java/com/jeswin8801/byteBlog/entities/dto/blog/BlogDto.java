package com.jeswin8801.byteBlog.entities.dto.blog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    // Is sent only when the requesting user is the author of the blog
    private String id;

    private AuthorDto author;

    @JsonProperty("time-since-creation")
    private Instant timeSinceCreation; // will be sorted by client

    private String heading;

    private String description;

    private Set<String> tags;

    @JsonProperty("primary-tag")
    private String primaryTag;

    @JsonProperty("markdown-file-url")
    private String markdownFileUrl;

    private Set<String> images;

    private Set<CommentDto> comments;
}
