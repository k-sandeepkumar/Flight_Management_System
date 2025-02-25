package com.project.flight_management_system.exception;

public class AirhostessIdNotFound extends RuntimeException{
	private String message="Airhostess Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
} 