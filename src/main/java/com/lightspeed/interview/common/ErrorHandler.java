package com.lightspeed.interview.common;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleException(NoSuchElementException noSuchElementException) {
        log.error("noSuchElementException error: {} ", noSuchElementException.getMessage());
        return ResponseEntity.badRequest().body("Item can't be found");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleException(ConstraintViolationException constraintViolationException) {
        log.error("constraintViolationException error: {} ", constraintViolationException.getMessage()  );
        return ResponseEntity.badRequest().body(constraintViolationException.getMessage());
    }
}
