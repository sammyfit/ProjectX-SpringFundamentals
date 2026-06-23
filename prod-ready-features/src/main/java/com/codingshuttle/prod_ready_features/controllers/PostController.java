package com.codingshuttle.prod_ready_features.controllers;

import com.codingshuttle.prod_ready_features.dto.PostDto;
import com.codingshuttle.prod_ready_features.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
@Tag(name = "Posts", description = "Endpoints for creating, retrieving and updating posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    @Operation(summary = "Get all posts", description = "Returns the list of all posts")
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    @Operation(summary = "Create a new post")
    public PostDto createNewPost(@RequestBody PostDto inputPost) {
        return postService.createNewPost(inputPost);
    }

    @GetMapping("/{postId}")
    @Operation(summary = "Get a post by id")
    public PostDto getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("{postId}")
    @Operation(summary = "Update an existing post by id")
    public PostDto updatePost(@RequestBody PostDto inputPost, @PathVariable Long postId) {
        return postService.updatePost(inputPost, postId);
    }
}
