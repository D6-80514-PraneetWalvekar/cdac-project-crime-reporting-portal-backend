package com.app.exceptionhandler;

import com.app.custom_exceptions.ResourseNotFound;

import com.app.utilities.ApiResponseData;
import com.app.utilities.ApiResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourseNotFound.class)
    public ResponseEntity<ApiResponseData<String>> handleResourseNotFound(ResourseNotFound ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseData<String>(ApiResponseStatus.ERROR, ex.getMessage(), LocalDateTime.now()));
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponseData<String>> handleRuntimeException(RuntimeException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseData<String>(ApiResponseStatus.ERROR,ex.getMessage(),LocalDateTime.now()));
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        Map<String , String > map = ex.getFieldErrors().stream().collect(Collectors.toMap(
                FieldError::getField, FieldError::getDefaultMessage
        ));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseData<Map<String,String>>(ApiResponseStatus.ERROR,map,LocalDateTime.now()));
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponseData<String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponseData<String>(ApiResponseStatus.ERROR,"wrong type!",LocalDateTime.now()));
    }
}
