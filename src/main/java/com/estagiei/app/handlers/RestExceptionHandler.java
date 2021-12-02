package com.estagiei.app.handlers;

import com.estagiei.app.errors.BuilderError;
import com.estagiei.app.errors.ValidationExceptionError;
import com.estagiei.app.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(
            MethodArgumentNotValidException validationException) {

        Map<String, String> invalidFields = new HashMap<>();

        validationException.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            invalidFields.put(fieldName, errorMessage);
        });

        ValidationExceptionError error = BuilderError.newBuild(ValidationExceptionError.class)
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Validation Error")
                .detail(validationException.getMessage())
                .fields(invalidFields)
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(
            NotFoundException notFoundException) {
        ValidationExceptionError error = BuilderError.newBuild(ValidationExceptionError.class)
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Not Found")
                .detail(notFoundException.getMessage())
                .build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
