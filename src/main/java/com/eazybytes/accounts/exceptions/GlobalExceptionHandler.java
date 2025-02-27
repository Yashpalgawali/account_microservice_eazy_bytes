package com.eazybytes.accounts.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.eazybytes.accounts.DTO.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlredyExistsException(CustomerAlreadyExistsException exception,
								WebRequest webRequest){
		
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(
				webRequest.getDescription(false),HttpStatus.BAD_REQUEST,exception.getMessage(),LocalDateTime.now()
					);
		
		 return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.BAD_REQUEST);
	}
}
