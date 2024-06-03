package com.example.springbootproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        APIException apiException = new APIException(
                HttpStatus.NOT_FOUND,
                notFoundException.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

    @ExceptionHandler({ConflictException.class})
    public ResponseEntity<Object> handleConflictException(ConflictException conflictException) {
        APIException apiException = new APIException(
                HttpStatus.CONFLICT,
                conflictException.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
}
