package com.capgemini.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlreadyEmployeeExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyEmployeeExistException(String errorMessage) {
		super(errorMessage);
	}
}
