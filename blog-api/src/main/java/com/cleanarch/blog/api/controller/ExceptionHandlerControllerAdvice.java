package com.cleanarch.blog.api.controller;

import com.cleanarch.blog.api.exception.ErrorMessage;
import com.cleanarch.blog.domain.exception.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

  @ExceptionHandler(PostNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  ResponseEntity<ErrorMessage> handleNotFound(PostNotFoundException ex) {
    ErrorMessage err = new ErrorMessage(ex);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }
}
