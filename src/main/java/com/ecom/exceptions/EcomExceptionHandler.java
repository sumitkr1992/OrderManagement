package com.ecom.exceptions;

import com.ecom.constants.ApplicationConstants;
import com.ecom.constants.ErrorCodes;
import com.ecom.model.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EcomExceptionHandler {
	
	@ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> handleException(ProductException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(e.getErrorCode());
        errorResponse.setErrorMessage(ErrorCodes.resolveMessage(e.getErrorCode()));
        HttpStatus httpStatus = ErrorCodes.resolveStatus(e.getErrorCode());

        return new ResponseEntity<>(errorResponse, null, (httpStatus != null) ? httpStatus:HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ItemException.class)
    public ResponseEntity<ErrorResponse> handleException(ItemException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(e.getErrorCode());
        errorResponse.setErrorMessage(ErrorCodes.resolveMessage(e.getErrorCode()));
        HttpStatus httpStatus = ErrorCodes.resolveStatus(e.getErrorCode());

        return new ResponseEntity<>(errorResponse, null, (httpStatus != null) ? httpStatus:HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(OrderException.class)
    public ResponseEntity<ErrorResponse> handleException(OrderException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(e.getErrorCode());
        errorResponse.setErrorMessage(ErrorCodes.resolveMessage(e.getErrorCode()));
        HttpStatus httpStatus = ErrorCodes.resolveStatus(e.getErrorCode());

        return new ResponseEntity<>(errorResponse, null, (httpStatus != null) ? httpStatus:HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponse> handleException(GeneralException e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(ApplicationConstants.ERROR_500);
        errorResponse.setErrorMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
