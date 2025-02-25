package com.project.flight_management_system.exception;

public class PilotIdNotFound extends RuntimeException{
	private String message="Pilot Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}