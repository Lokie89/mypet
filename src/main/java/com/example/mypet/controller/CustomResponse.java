package com.example.mypet.controller;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomResponse<T> {

    private T object;

    public CustomResponse(T object) {
        this.object = object;
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<T> handleError() {
        return responseBadRequest();
    }

    public ResponseEntity<T> responseBadRequest() {
        return responseEntity(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<T> responseOK() {
        return responseEntity(HttpStatus.OK);
    }

    private ResponseEntity<T> responseEntity(HttpStatus httpStatus) {
        return new ResponseEntity<>(this.object, httpStatus);
    }

}
