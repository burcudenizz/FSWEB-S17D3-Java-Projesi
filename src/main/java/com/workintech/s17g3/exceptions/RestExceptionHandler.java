package com.workintech.s17g3.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class RestExceptionHandler {

    public ResponseEntity<AnimalErrorResponse> handleException(AnimalException exception){
        AnimalErrorResponse response = new AnimalErrorResponse(exception.getStatus().value(),exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,exception.getStatus());
    }

public ResponseEntity<AnimalErrorResponse> handleAnimalException(AnimalException exception){
        AnimalErrorResponse response= new AnimalErrorResponse(exception.getStatus().value(),exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,exception.getStatus());
}

}
