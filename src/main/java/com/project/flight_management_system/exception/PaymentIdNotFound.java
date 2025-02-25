package com.project.flight_management_system.exception;

public class PaymentIdNotFound extends RuntimeException{
	private String message="Payment Id not found in the DB";

	public String getMessage() {
		return message;
	}
	
	
}