package com.fastcampus.blog.request.post;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
@Builder
public class GetPostsRequest {

    private Integer pageNo;
    private Integer limit;

}
