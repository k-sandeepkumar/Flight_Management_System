package com.project.flight_management_system.exception;

public class PassportIdNotFound extends RuntimeException{
	private String message="Passport Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}
