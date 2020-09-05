package com.infrr.rest.infrrpoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(FileStorageException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException (FileStorageException ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorResponse> handleUserException (Exception ex) {
        ErrorResponse error = new ErrorResponse(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE.value(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE);
    }

}
