package com.fastcampus.blog.request.post;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class UpdatePostByIdRequest {
    @Size(min = 3, message = "title minimal 2 character")
    @NotNull
    private String title;
    @Size(min = 3, message = "Content minimal 2 character")
    @NotNull
    private String content;
}
