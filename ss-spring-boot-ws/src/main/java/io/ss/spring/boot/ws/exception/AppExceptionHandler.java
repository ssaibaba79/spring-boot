package io.ss.spring.boot.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.ss.spring.boot.ws.response.ErrorResponse;

/**
 * Default Global Exception Handler
 * @author sarsaiba
 *
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request) {
		ErrorResponse error = new ErrorResponse(new Date(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<> (error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<Object> handleUserServiceException(UserServiceException unfe, WebRequest request){
		ErrorResponse error = new ErrorResponse(new Date(), unfe.getMessage(), unfe.getCode());
		return new ResponseEntity<> (error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
