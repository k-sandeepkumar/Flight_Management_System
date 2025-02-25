package com.project.flight_management_system.exception;

public class FoodIdNotFound extends RuntimeException{
	private String message="Food Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}