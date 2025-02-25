package com.project.flight_management_system.exception;

public class PassengersIdNotFound extends RuntimeException{
	private String message="Passengers Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}