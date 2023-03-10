package com.itbank.exception;

public class notUserPhoneException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "숫자만 입력하세요";
	}
	
}
