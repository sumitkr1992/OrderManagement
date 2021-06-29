package com.ecom.exceptions;

public class OrderException extends RuntimeException {
	private int errorCode;

    public int getErrorCode(){
        return this.errorCode;
    }

    public OrderException() {
        super();
    }

    public OrderException(int errorCode){
        super();
        this.errorCode = errorCode;
    }

    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
