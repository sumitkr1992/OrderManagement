package com.ecom.constants;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

public enum ErrorCodes {
	
	PRODUCT_NOT_FOUND(9001,"Product ID not found!!", HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_IN_STOCK(9002, "Product not in Stock!!", HttpStatus.BAD_REQUEST),
    PRODUCT_INSERT_ERROR(9003, "Product initialization error!!", HttpStatus.BAD_REQUEST),
    ORDER_LIST_ERROR(9004, "Order list empty!!", HttpStatus.BAD_REQUEST);
	

    private final int errorCode;
    private final String message;
    private final HttpStatus httpStatus;
    private static final ErrorCodes[] errorCodes;

    static{
        errorCodes = values();
    }

    private ErrorCodes(int errorCode, String message, HttpStatus httpStatus){
        this.errorCode = errorCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }
    
    @Nullable
    public static HttpStatus resolveStatus(int errorCode) {
    	for(ErrorCodes e : errorCodes){
            if(e.errorCode == errorCode){
                return e.httpStatus;
            }
        }
        return null;
    }


    @Nullable
    public static String resolveMessage(int errorCode){
        for(ErrorCodes e : errorCodes){
            if(e.errorCode == errorCode){
                return e.message;
            }
        }
        return null;
    }

}
