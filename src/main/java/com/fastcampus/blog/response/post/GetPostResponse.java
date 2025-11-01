package com.fastcampus.blog.response.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPostResponse {
    private Integer id;
    private String title;
    private String content;
    private Instant updatedAt;
    private Instant createdAt;
    private CreatePostResponse.User author;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class User{
        private String name;
    }
}
