package com.project.flight_management_system.exception;

public class AddressIdNotFound extends RuntimeException{
	private String message="Address Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}