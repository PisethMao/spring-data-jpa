package com.co.istad.piseth.spring_web_mvc.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@RestControllerAdvice
public class AppGlobalException {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleException(ResponseStatusException e) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .status(e.getStatusCode().toString())
                .message(e.getReason())
                .code(e.getStatusCode().value())
                .timestamp(Instant.now()).build();
        return new ResponseEntity<>(errorResponse, e.getStatusCode());
    }
}
