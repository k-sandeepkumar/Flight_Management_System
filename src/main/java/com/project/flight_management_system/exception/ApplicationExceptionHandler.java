package com.project.flight_management_system.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.flight_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	@Autowired
	ResponseStructure <String> responseStructure;
	
	@ExceptionHandler(AirportIdNotFound.class)
	public ResponseStructure<String> airportIdNotFound(AirportIdNotFound airportIdNotFound){
		responseStructure.setMessage("aiportId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public ResponseStructure<String> addressIdNotFound(AddressIdNotFound addressIdNotFound){
		responseStructure.setMessage("addressId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	@ExceptionHandler(AirhostessIdNotFound.class)
	public ResponseStructure<String> airhostessIdNotFound(AirhostessIdNotFound airhostessIdNotFound){
		responseStructure.setMessage("airhostessId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	@ExceptionHandler(FlightIdNotFound.class)
	public ResponseStructure<String> flightIdNotFound(FlightIdNotFound flightIdNotFound){
		responseStructure.setMessage("flightId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	@ExceptionHandler(FoodIdNotFound.class)
	public ResponseStructure<String> foodIdNotFound(FoodIdNotFound foodIdNotFound){
		responseStructure.setMessage("flightId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	@ExceptionHandler(PassengersIdNotFound.class)
	public ResponseStructure<String> passengersIdNotFound(PassengersIdNotFound passengersIdNotFound){
		responseStructure.setMessage("passengersId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	@ExceptionHandler(PassportIdNotFound.class)
	public ResponseStructure<String> passportIdNotFound(PassportIdNotFound passportIdNotFound){
		responseStructure.setMessage("passportId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	@ExceptionHandler(PaymentIdNotFound.class)
	public ResponseStructure<String> paymentIdNotFound(PaymentIdNotFound paymentIdNotFound){
		responseStructure.setMessage("paymentId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	@ExceptionHandler(PilotIdNotFound.class)
	public ResponseStructure<String> pilotIdNotFound(PilotIdNotFound pilotIdNotFound){
		responseStructure.setMessage("pilotId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	@ExceptionHandler(SeatIdNotFound.class)
	public ResponseStructure<String> seatIdNotFound(SeatIdNotFound seatIdNotFound){
		responseStructure.setMessage("seatId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	@ExceptionHandler(TicketIdNotFound.class)
	public ResponseStructure<String> ticketIdNotFound(TicketIdNotFound ticketIdNotFound){
		responseStructure.setMessage("ticketId not found in DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData("No data Available");
		return responseStructure;
		
	}
	
}
