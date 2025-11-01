package com.fastcampus.blog.mapper;

import com.fastcampus.blog.entity.Post;
import com.fastcampus.blog.request.post.CreatePostRequest;
import com.fastcampus.blog.response.post.CreatePostResponse;
import com.fastcampus.blog.response.post.GetPostResponse;
import com.fastcampus.blog.response.post.UpdatePostByIdResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post mapToCreatePostResponse(CreatePostRequest postRequest);

//    @Mapping(source = "slug", target = "path")
    CreatePostResponse mapToCreatePostResponse(Post post);

    GetPostResponse mapToGetResponse(Post post);

    GetPostResponse mapToGetPostResponse(Post post);

    UpdatePostByIdResponse mapToUpdatePostResponse(Post post);

}
