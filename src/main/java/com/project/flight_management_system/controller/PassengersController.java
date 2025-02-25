package com.project.flight_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.dto.Passengers;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.service.PassengersService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class PassengersController {
	@Autowired
	PassengersService passengersService;
	@PutMapping("/addExistingPassportToExistingPassengers")
	public Passengers addExistingPassportToExistingPassengers(@RequestParam int passportId,@RequestParam int passengersId) {
		return passengersService.addExistingPassportToExistingPassengers(passportId, passengersId);
	}
	@PutMapping("/addExistingSeatToExistingPassengers")
	public Passengers addExistingSeatToExistingPassengers(@RequestParam int seatId,@RequestParam int passengersId) {
		return passengersService.addExistingSeatToExistingPassengers(seatId, passengersId);
	}
	@PutMapping("/addExistingAddressToExistingPassengers")
	public Passengers addExistingAddressToExistingPassengers(@RequestParam int addressId,@RequestParam int passengersId) {
		return passengersService.addExistingAddressToExistingPassengers(addressId, passengersId);
	}
	@PutMapping("/addExistingTicketToExistingPassengers")
	public Passengers addExistingTicketToExistingPassengers(@RequestParam int ticketId,@RequestParam int passengersId) {
		return passengersService.addExistingTicketToExistingPassengers(ticketId, passengersId);
	}
	@PutMapping("/addNewTicketToExistingPassengers")
	public Passengers addNewTicketToExistingPassengers(@RequestParam int passengersId,@RequestBody Ticket newTicket) {
		return passengersService.addNewTicketToExistingPassengers(passengersId, newTicket);
	}
	@PutMapping("/addExistingFoodToExistingPassengers")
	public Passengers addExistingFoodToExistingPassengers(@RequestParam int foodId,@RequestParam int passengersId) {
		return passengersService.addExistingFoodToExistingPassengers(foodId, passengersId);
	}
	@PutMapping("/addNewFoodToExistingPassengers")
	public Passengers addNewFoodToExistingPassengers(@RequestParam int passengersId,@RequestBody Food newFood) {
		return passengersService.addNewFoodToExistingPassengers(passengersId, newFood);
	}
	@Operation(summary = "Save passenger", description = "API is used to save the passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  passenger created"),
			@ApiResponse(responseCode = "404", description = "passenger not found for the given id") })
	@PostMapping("/savePassengers")
	public ResponseStructure<Passengers> savePassengers(@RequestBody Passengers passengers) {
		return passengersService.savePassengers(passengers);
	}
	
	@Operation(summary = "fetch passenger", description = "API is used to fetch the passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  passenger fetched"),
			@ApiResponse(responseCode = "404", description = "passenger not found for the given id") })
	@GetMapping("/fetchPassengersById")
	public ResponseStructure<Passengers> fetchPassengersById(@RequestParam int passengersById) {
		return passengersService.fetchPassengersById(passengersById);
	}
	@Operation(summary = "delete passenger", description = "API is used to delete the passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  passenger deleted"),
			@ApiResponse(responseCode = "404", description = "passenger not found for the given id") })
	@DeleteMapping("/deletePassengersById")
	public ResponseStructure<Passengers> deletePassengersById(@RequestParam int passengersById) {
		return passengersService.deletePassengersById(passengersById);
	}
	
	@Operation(summary = "update passenger", description = "API is used to update the passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  passenger updated"),
			@ApiResponse(responseCode = "404", description = "passenger not found for the given id") })
	@PutMapping("/updatePassengersById")
	public ResponseStructure<Passengers> updatePassengersById(@RequestParam int oldPassengersId,@RequestBody Passengers newPassengers) {
		return passengersService.updatePassengersById(oldPassengersId, newPassengers);
	}
	
	@Operation(summary = "fetch all passenger", description = "API is used to fetch all the passenger")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  passenger fetch all"),
			@ApiResponse(responseCode = "404", description = "passenger not found for the given id") })
	@GetMapping("/fetchAllPassengers")
	public ResponseStructureAll<Passengers> fetchAllPassengers() {
		return passengersService.fetchAllPassengers();
	}
}
