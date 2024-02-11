package com.app.exception;

public class NoSuchEntityExistsException extends RuntimeException{

	public NoSuchEntityExistsException(String msg) {
		super(msg);
	}
}
