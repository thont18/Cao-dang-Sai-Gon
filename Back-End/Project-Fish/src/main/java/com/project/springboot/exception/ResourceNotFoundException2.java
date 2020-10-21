package com.project.springboot.exception;

public class ResourceNotFoundException2 extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException2() {
		this("Resource not found!");
	}

	public ResourceNotFoundException2(String message) {
		this(message, null);
	}

	public ResourceNotFoundException2(String message, Throwable cause) {
		super(message, cause);
	}
}
