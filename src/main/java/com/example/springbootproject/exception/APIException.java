package com.example.springbootproject.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class APIException {
    private final HttpStatus httpStatus;
    private final String message;
    private final LocalDateTime localDateTime;
}
