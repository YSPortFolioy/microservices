package com.youssadi.controller;

import com.youssadi.dto.responses.ErrorResponses;
import com.youssadi.exceptions.ErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ErrorResponses> handleErrorException(ErrorException ex, WebRequest request){
        String path = request.getDescription(true).replace("uri=", "");
        ErrorResponses errorResponse = new ErrorResponses(ex.getMessage(), path, new java.util.Date());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }
}
