package com.gamer.exception;

public class IllegalScoreException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalScoreException(String message) {
        super(message);
    }

    public IllegalScoreException(String message, Throwable throwable) {
        super(message, throwable);
    }
	
}
