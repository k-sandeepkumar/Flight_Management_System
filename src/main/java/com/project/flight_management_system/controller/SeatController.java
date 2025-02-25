package com.project.flight_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.service.SeatService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class SeatController {
	@Autowired
	SeatService seatService;
	@Operation(summary = "Save Seat", description = "API is used to save the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Seat created"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	@PostMapping("/saveSeat")
	public ResponseStructure<Seat> saveSeat(@RequestBody Seat seat) {
		return seatService.saveSeat(seat);
	}
	
	
	@Operation(summary = "fetch Seat", description = "API is used to fetch the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  Seat fetched"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	@GetMapping("/fetchSeatById")
	public ResponseStructure<Seat> fetchSeatById(@RequestParam int seatById) {
		return seatService.fetchSeatById(seatById);
	}
	
	
	@Operation(summary = "delete Seat", description = "API is used to delete the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Seat deleted"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	@DeleteMapping("/deleteSeatById")
	public ResponseStructure<Seat> deleteSeatById(@RequestParam int seatById) {
		return seatService.deleteSeatById(seatById);
	}
	
	@Operation(summary = "update Seat", description = "API is used to update the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Seat updated"),
			@ApiResponse(responseCode = "404", description = "Seat not found for the given id") })
	@PutMapping("/updateSeatById")
	public ResponseStructure<Seat> updateSeatById(@RequestParam int oldSeatId,@RequestBody Seat newSeat) {
		return seatService.updateSeatById(oldSeatId, newSeat);
	}
	
	@Operation(summary = "fetch all Seat", description = "API is used to fetch all the Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Seat fetch all"),
			@ApiResponse(responseCode = "404", description = "Seat not found ") })
	@GetMapping("/fetchAllSeat")
	public ResponseStructureAll<Seat> fetchAllSeat() {
		return seatService.fetchAllSeat();
	}
}
