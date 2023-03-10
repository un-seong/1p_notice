package com.itbank.exception;

public class categoryNull extends Exception {
	
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "카테고리를 선택하세요!";
	}
		
}
