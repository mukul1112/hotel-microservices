package com.lcwd.user.service.Userservice.exceptions;

import com.lcwd.user.service.Userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ResourcesNotfoundeException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourcesNotfoundeException ex){

        String Message=ex.getMessage();
        ApiResponse response=new ApiResponse();
        response.setMessage(Message);
        response.setSuccess(true);
        response.setStatus(HttpStatus.NOT_FOUND);



        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);





    }

}
