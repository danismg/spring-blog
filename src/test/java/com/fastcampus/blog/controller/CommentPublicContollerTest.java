package com.fastcampus.blog.controller;

import com.fastcampus.blog.exception.ApiException;
import com.fastcampus.blog.request.comment.GetCommentRequest;
import com.fastcampus.blog.response.comment.GetCommentResponse;
import com.fastcampus.blog.service.CommentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class CommentPublicContollerTest {

    @Autowired
    @InjectMocks
    CommentPublicController commentPublicController;

    @Mock
    CommentService commentService;

    private AutoCloseable mock;

    @BeforeEach
    void beforeEach() {
        mock = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void afterEach() throws Exception {
        mock.close();
    }

    @Test
    void getComments_givenOneComment_shouldReturnOne(){
        GetCommentRequest request = GetCommentRequest
                .builder()
                .postSlug("test")
                .pageNo(0)
                .limit(10)
                .build();

        GetCommentResponse getCommentResponse = new GetCommentResponse();
        getCommentResponse.setName("Daniel");
        getCommentResponse.setEmail("daniel@gmail.com");
        getCommentResponse.setBody("Daniel");
        getCommentResponse.setId(1);

        List<GetCommentResponse> actualCommentResponse =
                List.of(getCommentResponse);

        when(commentService.getComments(request)).thenReturn(actualCommentResponse);

        List<GetCommentResponse> commentResponses =
                commentPublicController
                        .getCategories("test", 0, 10);


        Assertions.assertNotNull(commentResponses);
        Assertions.assertEquals(commentResponses.size(), 1);
        Assertions.assertEquals(commentResponses.getFirst().getId(), 1);
        Assertions.assertEquals(commentResponses.getFirst().getBody(), "Daniel");
    }

    @Test
    void getComments_givenPostValid_shouldThrowError(){
        GetCommentRequest request = GetCommentRequest
                .builder()
                .postSlug("test")
                .pageNo(0)
                .limit(10)
                .build();
        when(commentService.getComments(request))
                .thenThrow(new ApiException("Comment not Found", HttpStatus.NOT_FOUND));
//        List<GetCommentResponse> commentResponses =
//                commentPublicController
//                        .getAllController("test", 0, 10);
//        Assertions.assertNull(commentResponses);

//        agar hijau dan tidak merah
        Assertions.assertThrows(ApiException.class, ()-> commentPublicController
                .getCategories("test", 0, 10));
    }

}
