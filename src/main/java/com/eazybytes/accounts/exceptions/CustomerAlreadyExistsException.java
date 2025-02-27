package com.eazybytes.accounts.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1985723482348L;

	public CustomerAlreadyExistsException(String message) {
		super(message);
	}

	
}
