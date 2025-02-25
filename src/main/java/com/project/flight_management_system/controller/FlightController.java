package com.project.flight_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.dto.Passengers;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.service.FlightService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class FlightController {
	@Autowired
	FlightService flightService;
	@PutMapping("/addExistingPilotToExistingFlight")
	public Flight addExistingPilotToExistingFlight(@RequestParam int pilotId,@RequestParam int flightId) {
		return flightService.addExistingPilotToExistingFlight(pilotId, flightId);
	}
	@PutMapping("/addNewPilotToExistingFlight")
	public Flight addNewPilotToExistingFlight(@RequestParam int flightId,@RequestBody Pilot newPilot) {
		return flightService.addNewPilotToExistingFlight(flightId, newPilot);
	}	
	@PutMapping("/addExistingAirhostessToExistingFlight")
	public Flight addExistingAirhostessToExistingFlight(@RequestParam int airhostessId,@RequestParam int flightId) {
		return flightService.addExistingAirhostessToExistingFlight(airhostessId, flightId);
	}
	@PutMapping("/addNewAirhostessToExistingFlight")
	public Flight addNewAirhostessToExistingFlight(@RequestParam int flightId,@RequestBody Airhostess newAirhostess) {
		return flightService.addNewAirhostessToExistingFlight(flightId, newAirhostess);
	}
	@PutMapping("/addExistingPassengersToExistingFlight")
	public Flight addExistingPassengersToExistingFlight(@RequestParam int passengersId,@RequestParam int flightId) {
		return flightService.addExistingPassengersToExistingFlight(passengersId, flightId);
	}
	@PutMapping("/addNewPassengersToExistingFlight")
	public Flight addNewPassengersToExistingFlight(@RequestParam int flightId,@RequestBody Passengers newPassengers) {
		return flightService.addNewPassengersToExistingFlight(flightId, newPassengers);
	}
	
	@Operation(summary = "Save Flight", description = "API is used to save the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Flight created"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PostMapping("/saveFlight")
	public ResponseStructure<Flight> saveFlight(@RequestBody Flight flight) {
		return flightService.saveFlight(flight);
	}
	
	@Operation(summary = "fetch Flight", description = "API is used to fetch the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  Flight fetched"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@GetMapping("/fetchFlightById")
	public ResponseStructure<Flight> fetchFlightById(@RequestParam int flightById) {
		return flightService.fetchFlightById(flightById);
	}
	
	@Operation(summary = "delete Flight", description = "API is used to delete the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Flight deleted"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@DeleteMapping("/deleteFlightById")
	public ResponseStructure<Flight> deleteFlightById(@RequestParam int flightById) {
		return flightService.deleteFlightById(flightById);
	}
	
	@Operation(summary = "update Flight", description = "API is used to update the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Flight updated"),
			@ApiResponse(responseCode = "404", description = "Flight not found for the given id") })
	@PutMapping("/updateFlightById")
	public ResponseStructure<Flight> updateFlightById(@RequestParam int oldFlightId,@RequestBody Flight newFlight) {
		return flightService.updateFlightById(oldFlightId, newFlight);
	}
	
	@Operation(summary = "fetch all Flight", description = "API is used to fetch all the Flight")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  Flight fetch all"),
			@ApiResponse(responseCode = "404", description = "Flight not found ") })
	@GetMapping("/fetchAllFlight")
	public ResponseStructureAll<Flight> fetchAllFlight() {
		return flightService.fetchAllFlight();
	}
}
