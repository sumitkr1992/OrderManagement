package com.ecom.exceptions;

public class ItemException extends RuntimeException {
	private int errorCode;

    public int getErrorCode(){
        return this.errorCode;
    }

    public ItemException() {
        super();
    }

    public ItemException(int errorCode){
        super();
        this.errorCode = errorCode;
    }

    public ItemException(String message) {
        super(message);
    }

    public ItemException(String message, Throwable cause) {
        super(message, cause);
    }
}
