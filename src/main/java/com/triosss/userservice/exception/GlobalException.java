package com.triosss.userservice.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> m = new HashMap<>();


        exception.getBindingResult().getFieldErrors().forEach(error->{
           String errors = error.getDefaultMessage();
            String fieldName = error.getField();
            m.put(fieldName,errors);
        });
        return new ResponseEntity<>(m, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDatabaseConstraintViolation(DataIntegrityViolationException ex) {
        return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
    }
}
