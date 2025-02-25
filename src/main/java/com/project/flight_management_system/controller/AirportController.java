package com.project.flight_management_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.service.AirportService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Flight;
@RestController
public class AirportController {
	@Autowired
	AirportService airportService;
	
	@Operation(summary = "Fetch Airport", description = "API is used to fetch the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  airport fetched"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	
	@GetMapping("/fetchAirportById")
	public ResponseStructure<Airport> fetchAirportById(@RequestParam int airportById) {
		return airportService.fetchAirportById(airportById);
	}
	
	
	@Operation(summary = "fetch all Airport", description = "API is used to fetch all the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  all airport fetched"),
			@ApiResponse(responseCode = "404", description = "Airports are not found for the given id") })
	
	@GetMapping("/fetchAllAirport")
	public ResponseStructureAll<Airport> fetchAllAirport() {
		return airportService.fetchAllAirport();
	}
	
	
	@Operation(summary = "Save Airport", description = "API is used to save the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  airport created"),
			@ApiResponse(responseCode = "404", description = "Airport not able to creates for the given id") })
	@PostMapping("/saveAirport")
	public ResponseStructure<Airport> saveAirport(@RequestBody Airport airport) {
		return airportService.saveAirport(airport);
	}
	
	@Operation(summary = "delete Airport", description = "API is used to delete the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  airport deleted"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	
	@DeleteMapping("/deleteAirportById")
	public ResponseStructure<Airport> deleteAirportById(@RequestParam int airportById) {
		return airportService.deleteAirportById(airportById);
	}
	
	
	@Operation(summary = "update Airport", description = "API is used to update the Airport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  airport updated"),
			@ApiResponse(responseCode = "404", description = "Airport not found for the given id") })
	@PutMapping("/updateAirportById")
	public ResponseStructure<Airport> updateAirportById(@RequestParam int oldAirportId,@RequestBody Airport newAirport) {
		return airportService.updateAirportById(oldAirportId, newAirport);
	}
	
	
	
	@PutMapping("/addExistingAddressToExistingAirport")
	public Airport addExistingAddressToExistingAirport(@RequestParam int addressId,@RequestParam int airportId) {
		return airportService.addExistingAddressToExistingAirport(addressId, airportId);
	}
	
	@PutMapping("/addExistingFlightToExistingAirport")
	public Airport addExistingFlightToExistingAirport(@RequestParam int flightId,@RequestParam int airportId) {
		return airportService.addExistingFlightToExistingAirport(flightId, airportId);
	}
	@PutMapping("/addNewFlightToExistingAirport")
	public Airport addNewFlightToExistingAirport(@RequestParam int airportId,@RequestBody Flight newFlight) {
		return airportService.addNewFlightToExistingAirport(airportId, newFlight);
	}
	
	
	
//	@GetMapping("/fetchAllAirport")
//	public List<Airport> fetchAllAirport() {
//		return airportService.fetchAllAirport();
//	}
//	@GetMapping("/fetchAirportById")
//	public Airport fetchAirportById(@RequestParam int airportById) {
//		return airportService.fetchAirportById(airportById);
//	}
//	@PostMapping("/saveAirport")
//	public Airport saveAirport(@RequestBody Airport airport) {
//		return airportService.saveAirport(airport);
//	}
//	@DeleteMapping("/deleteAirportById")
//	public Airport deleteAirportById(@RequestParam int airportById) {
//		return airportService.deleteAirportById(airportById);
//	}
//	@PutMapping("/updateAirportById")
//	public Airport updateAirportById(@RequestParam int oldAirportId,@RequestBody Airport newAirport) {
//		return airportService.updateAirportById(oldAirportId, newAirport);
//	}
}
