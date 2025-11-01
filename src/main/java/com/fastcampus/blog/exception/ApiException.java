package com.fastcampus.blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    @Getter
    private final HttpStatus httpStatus;
    @Getter
    private final String message;

    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;

    }
}
