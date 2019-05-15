package com.in28minutes.rest.webservices.restfulwebservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse=
                new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,

                                                                  HttpHeaders headers,HttpStatus status,WebRequest request){
// this response is difficult for the user to read. Rather use send a more readable message
        ExceptionResponse exceptionResponse=
                new ExceptionResponse(new Date(),ex.getMessage(),ex.getBindingResult().toString());
        //Can add a static message. This is shorter and more readable, but may not provide a lot of information
//        ExceptionResponse exceptionResponse=
//             new ExceptionResponse(new Date(),ex.getMessage(),"Invalid request");
        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
