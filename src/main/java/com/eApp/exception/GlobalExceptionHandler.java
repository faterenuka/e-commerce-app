package com.eApp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerException.class) 
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(CustomerException e,WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDetails(req.getDescription(false));
		err.setHttpStatus(HttpStatus.BAD_REQUEST);
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage()) ;
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(AddressException.class) 
	public ResponseEntity<MyErrorDetails> addressExceptionHandler(AddressException e,WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDetails(req.getDescription(false));
		err.setHttpStatus(HttpStatus.BAD_REQUEST);
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage()) ;
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(ProductException.class) 
	public ResponseEntity<MyErrorDetails> productExceptionHandler(ProductException e,WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDetails(req.getDescription(false));
		err.setHttpStatus(HttpStatus.BAD_REQUEST);
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage()) ;
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(OrderDetailsException.class) 
	public ResponseEntity<MyErrorDetails> orderDetailsExceptionHandler(OrderDetailsException e,WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDetails(req.getDescription(false));
		err.setHttpStatus(HttpStatus.BAD_REQUEST);
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage()) ;
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(OrderException.class) 
	public ResponseEntity<MyErrorDetails> orderExceptionHandler(OrderException e,WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDetails(req.getDescription(false));
		err.setHttpStatus(HttpStatus.BAD_REQUEST);
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage()) ;
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(CartException.class) 
	public ResponseEntity<MyErrorDetails> cartExceptionHandler(CartException e,WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDetails(req.getDescription(false));
		err.setHttpStatus(HttpStatus.BAD_REQUEST);
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage()) ;
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST) ;
	}
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception e,WebRequest req) {
		
		MyErrorDetails err = new MyErrorDetails();
		err.setDetails(req.getDescription(false));
		err.setHttpStatus(HttpStatus.BAD_REQUEST);
		err.setTimeStamp(LocalDateTime.now());
		err.setMessage(e.getMessage()) ;
		
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST) ;
	}
}
