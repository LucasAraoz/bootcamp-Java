package com.Integrador2.bo;

public class MyException extends Exception {
	private String message;

	public MyException(String messaje) {
		setMessage(messaje);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
