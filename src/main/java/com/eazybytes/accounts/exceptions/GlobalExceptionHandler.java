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

	// This exception is global , means if no exception handler is found, then here all the exceptions would be handled
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ErrorResponseDto> handleGlobalExceptions(Exception exception,
									WebRequest webRequest){
			
			ErrorResponseDto errorResponseDto = new ErrorResponseDto(
																	webRequest.getDescription(false),
																	HttpStatus.INTERNAL_SERVER_ERROR,
																	exception.getMessage(),
																	LocalDateTime.now()
																);
			
			 return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlredyExistsException(CustomerAlreadyExistsException exception,
								WebRequest webRequest){
		
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(
				webRequest.getDescription(false),HttpStatus.BAD_REQUEST,exception.getMessage(),LocalDateTime.now()
					);
		
		 return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception,
								WebRequest webRequest){
		
		ErrorResponseDto errorResponseDto = new ErrorResponseDto(
																webRequest.getDescription(false),
																HttpStatus.NOT_FOUND,
																exception.getMessage(),
																LocalDateTime.now()
															);
		
		 return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.NOT_FOUND);
	}
	
	
	
}
