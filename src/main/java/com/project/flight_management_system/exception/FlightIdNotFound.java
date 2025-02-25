package com.project.flight_management_system.exception;

public class FlightIdNotFound extends RuntimeException{
	private String message="Flight Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}