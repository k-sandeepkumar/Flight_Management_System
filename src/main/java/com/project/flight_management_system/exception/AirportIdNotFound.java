package com.project.flight_management_system.exception;

public class AirportIdNotFound extends RuntimeException{
	private String message="Airport Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}
