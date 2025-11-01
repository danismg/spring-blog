package com.fastcampus.blog.request.post;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
@Builder
public class GetPostByIdRequest {
    @Size(min = 1)
    private Long id;
}
