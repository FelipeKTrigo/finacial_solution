package com.util.financialbackend.advisor;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler({Exception.class})
    public Error advise(Exception e){
        return new Error(e.getMessage());
    }
}
