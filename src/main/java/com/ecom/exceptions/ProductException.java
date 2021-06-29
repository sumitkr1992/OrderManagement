package com.ecom.exceptions;

public class ProductException extends RuntimeException {

    private int errorCode;

    public int getErrorCode(){
        return this.errorCode;
    }

    public ProductException() {
        super();
    }

    public ProductException(int errorCode){
        super();
        this.errorCode = errorCode;
    }

    public ProductException(String message) {
        super(message);
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
    }
}
