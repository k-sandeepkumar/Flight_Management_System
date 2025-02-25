package com.project.flight_management_system.exception;

public class TicketIdNotFound extends RuntimeException{
	private String message="Ticket Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}