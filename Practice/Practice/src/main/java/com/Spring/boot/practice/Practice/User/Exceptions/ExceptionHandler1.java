package com.Spring.boot.practice.Practice.User.Exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Spring.boot.practice.Practice.User.UserResource.UserNotFound;
@ControllerAdvice
@RestController
public class ExceptionHandler1 extends ResponseEntityExceptionHandler  {
@ExceptionHandler(Exception.class)
public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
{
	ExceptionResponse response=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
	return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
}
@ExceptionHandler(UserNotFound.class)
public final ResponseEntity<Object> UserNotFoundException(Exception ex, WebRequest request)
{
	ExceptionResponse response=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
	return new ResponseEntity(response,HttpStatus.NOT_FOUND);
}
@ExceptionHandler(BadRequest.class)
public final ResponseEntity<Object> BadRequestException(Exception ex, WebRequest request)
{
	ExceptionResponse response=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
	return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
}
@Override
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	ExceptionResponse response=new ExceptionResponse(new Date(),ex.getMessage(),ex.getBindingResult().toString());
	return new ResponseEntity(response,HttpStatus.BAD_REQUEST); 
}

}
