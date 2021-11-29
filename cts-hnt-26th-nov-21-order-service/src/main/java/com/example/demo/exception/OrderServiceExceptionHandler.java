package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.ui.ErrorResponseModel;

@ControllerAdvice
public class OrderServiceExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleUniqueIdNotFoundException(IdNotFoundException e) {
		ErrorResponseModel errorResponseModel = new ErrorResponseModel();
		errorResponseModel.setMessage(e.getMessage());
		errorResponseModel.setErrorReportingTime(System.currentTimeMillis());
		errorResponseModel.setStatusCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseModel);

	}
}
