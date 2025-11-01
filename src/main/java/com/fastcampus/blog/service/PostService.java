package com.fastcampus.blog.service;

import com.fastcampus.blog.entity.Post;
import com.fastcampus.blog.exception.ApiException;
import com.fastcampus.blog.mapper.PostMapper;
import com.fastcampus.blog.repository.PostRepository;
import com.fastcampus.blog.request.post.*;
import com.fastcampus.blog.response.post.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostService {

    @Autowired
    PostRepository postRepository;

    public GetPostResponse getPostById(GetPostByIdRequest request) {
        Post post = postRepository
                .findFirstByIdAndIsDeleted(request.getId(), false)
                .orElseThrow(()-> new ApiException("Not Found", HttpStatus.NOT_FOUND));
        return PostMapper.INSTANCE.mapToGetResponse(post);
    }

    public UpdatePostByIdResponse updatePost(Long id, UpdatePostByIdRequest request) {
        Post post = postRepository
                .findFirstByIdAndIsDeleted(id, false)
                .orElseThrow(()-> new ApiException("Not Fount", HttpStatus.NOT_FOUND));

        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setUpdatedAt(Instant.now());
        postRepository.save(post);

        return PostMapper.INSTANCE.mapToUpdatePostResponse(post);
    }

    public CreatePostResponse createPost(CreatePostRequest request) {
        Post post = PostMapper.INSTANCE.mapToCreatePostResponse(request);
        post.setCreatedAt(Instant.now());
        post = postRepository.save(post);

        return PostMapper.INSTANCE.mapToCreatePostResponse(post);
    }

    // bot delete but soft delete agar aman brooo
    public DeletePostByIdResponse deletePost(Long id) {
        Post post = postRepository
                .findFirstById(id)
                .orElseThrow(()-> new ApiException("Not Found", HttpStatus.NOT_FOUND));

        post.setDeleted(true);
        postRepository.save(post);
        return DeletePostByIdResponse.builder().id(id).build();
    }


    public List<GetPostResponse> getPosts(GetPostsRequest request){
        List<Post>  posts = postRepository.findByIsDeleted(false);
        List<GetPostResponse> responses  = new ArrayList<>();
        posts.forEach(post -> responses.add(PostMapper.INSTANCE.mapToGetPostResponse(post)));
        return responses;
    }

}
