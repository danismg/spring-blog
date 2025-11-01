package com.fastcampus.blog.response.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostResponse {
    private Long id;
    private String title;
    private String content;
    private Instant createdAt;
    private User author;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class User{
        private String name;
    }
}
