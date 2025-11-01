package com.fastcampus.blog.controller;

import com.fastcampus.blog.request.ApiResponse;
import com.fastcampus.blog.request.post.CreatePostRequest;
import com.fastcampus.blog.request.post.GetPostByIdRequest;
import com.fastcampus.blog.request.post.GetPostsRequest;
import com.fastcampus.blog.request.post.UpdatePostByIdRequest;
import com.fastcampus.blog.response.post.CreatePostResponse;
import com.fastcampus.blog.response.post.DeletePostByIdResponse;
import com.fastcampus.blog.response.post.GetPostResponse;
import com.fastcampus.blog.response.post.UpdatePostByIdResponse;
import com.fastcampus.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/posts")
public class PostAdminController {

    @Autowired
    PostService postService;

    @PostMapping()
    public ResponseEntity<ApiResponse<CreatePostResponse>> createPost(@Valid @RequestBody CreatePostRequest createPostRequest) {

        CreatePostResponse response = postService.createPost(createPostRequest);
        return ResponseEntity.ok(ApiResponse.success("Post created successfully", response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UpdatePostByIdResponse>> updatePost(@PathVariable Long id,
                                                                          @Valid @RequestBody UpdatePostByIdRequest request) {
//        UpdatePostByIdRequest request = UpdatePostByIdRequest.builder().build()
        UpdatePostByIdResponse response = postService.updatePost(id, request);
        return ResponseEntity.ok(ApiResponse.success("Post updated successfully", response));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<DeletePostByIdResponse>> deletePost(@PathVariable Long id) {
        DeletePostByIdResponse response = postService.deletePost(id);
        return ResponseEntity.ok(ApiResponse.success("Post deleted successfully", response));
    }

}
