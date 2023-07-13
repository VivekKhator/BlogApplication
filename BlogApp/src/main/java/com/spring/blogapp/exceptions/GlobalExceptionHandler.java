package com.spring.blogapp.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.blogapp.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException resource){
		String message = resource.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
		Map<String, String> resp = new HashMap<>();
		
		methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error->{
			String fieldName = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();
			resp.put(fieldName, message);
		});
		
		return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	}
}
