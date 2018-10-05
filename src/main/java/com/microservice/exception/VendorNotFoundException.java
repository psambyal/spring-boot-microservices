package com.microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="This customer is not found in the system")
public class VendorNotFoundException extends Exception {
	private static final long serialVersionUID = 100L;
	
}
