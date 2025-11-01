package com.fastcampus.blog.response.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostByIdResponse {
    private String title;
    private String slug;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
    private User author;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class User{
        private String name;
    }
}
