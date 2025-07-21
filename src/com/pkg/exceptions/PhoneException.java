package com.pkg.exceptions;

@SuppressWarnings("serial")
public class PhoneException extends Exception{
	
	
	@SuppressWarnings("unused")
	private String errorMsg;

	public PhoneException(String errorMsg) {
		super(errorMsg);
		
		
	}

}
