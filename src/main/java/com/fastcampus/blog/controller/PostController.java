package com.fastcampus.blog.controller;

import com.fastcampus.blog.request.ApiResponse;
import com.fastcampus.blog.request.post.*;
import com.fastcampus.blog.response.post.*;
import com.fastcampus.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    public ResponseEntity<ApiResponse<List<GetPostResponse>>> getPosts(@RequestParam(required = false, defaultValue = "0") Integer pageNo,
                                          @RequestParam(required = false, defaultValue = "10") Integer limit) {
        GetPostsRequest request = GetPostsRequest.builder().pageNo(pageNo).limit(limit).build();
        List<GetPostResponse> posts = postService.getPosts(request);
        return ResponseEntity.ok(ApiResponse.success("Posts fetched successfully", posts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<GetPostResponse>> getPostById(@PathVariable Long id) {
        GetPostByIdRequest request = GetPostByIdRequest.builder().id(id).build();
        GetPostResponse post = postService.getPostById(request);
        return ResponseEntity.ok(ApiResponse.success("Post fetched successfully", post));
    }

}
