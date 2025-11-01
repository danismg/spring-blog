package com.fastcampus.blog.controller;

import com.fastcampus.blog.entity.Post;
import com.fastcampus.blog.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostPublicControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostRepository postRepository;


    @Test
    void getPostBySlug_givenValid_shouldReturnOK() throws Exception {

        Post post = new Post();
        post.setSlug("slug1");
        post.setTitle("title1");
        postRepository.save(post);

        mockMvc.perform(get("/api/public/posts/slug1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"title":"title1","body":null,"slug":"slug1","publishedAt":null,"commentCount":null,"published":false}
                        """));
    }

}
