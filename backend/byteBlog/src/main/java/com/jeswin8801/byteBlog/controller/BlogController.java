package com.jeswin8801.byteBlog.controller;

import com.jeswin8801.byteBlog.entities.dto.blog.PostBlogRequestDto;
import com.jeswin8801.byteBlog.service.webapp.abstracts.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/get-all-tags")
    public ResponseEntity<?> getAllTags() {
        return blogService.getAllTags().getResponseEntity();
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> addNewBlog(@RequestPart("blog") PostBlogRequestDto postBlogRequestDto,
                                        @RequestPart("markdown") MultipartFile markdownFile,
                                        @RequestPart(value = "images", required = false) List<MultipartFile> images) {
        return blogService
                .addNewBlog(postBlogRequestDto, markdownFile, images)
                .getResponseEntity();
    }

    // unrestricted access
    @GetMapping("/unrestricted/author/get-all-blogs")
    public ResponseEntity<?> getAllBlogsByUsername(@RequestParam String username) {
        return blogService.getAllBlogsByAuthor(username).getResponseEntity();
    }

    // unrestricted access
    @GetMapping("/unrestricted/get-blog")
    public ResponseEntity<?> getBlog(@RequestParam String headingUri) {
        return blogService.getBlogByHeading(headingUri).getResponseEntity();
    }

    @GetMapping("/unrestricted/author")
    public ResponseEntity<?> getAuthorDetails(@RequestParam String username) {
        return blogService.getBlogAuthorDetails(username).getResponseEntity();
    }
}
