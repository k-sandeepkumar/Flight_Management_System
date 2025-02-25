package com.project.flight_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.service.PilotService;
import com.project.flight_management_system.util.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class PilotController {
	@Autowired
	PilotService pilotService;
	@Operation(summary = "Save pilot", description = "API is used to save the pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  pilot created"),
			@ApiResponse(responseCode = "404", description = "pilot not found for the given id") })
	@PostMapping("/savePilot")
	public ResponseStructure<Pilot> savePilot(@RequestBody Pilot pilot) {
		return pilotService.savePilot(pilot);
	}
	
	@Operation(summary = "fetch pilot", description = "API is used to fetch the pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  pilot fetched"),
			@ApiResponse(responseCode = "404", description = "pilot not found for the given id") })
	@GetMapping("/fetchPilotById")
	public ResponseStructure<Pilot> fetchPilotById(@RequestParam int pilotById) {
		return pilotService.fetchPilotById(pilotById);
	}
	
	@Operation(summary = "delete pilot", description = "API is used to delete the pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  pilot deleted"),
			@ApiResponse(responseCode = "404", description = "pilot not found for the given id") })
	@DeleteMapping("/deletePilotById")
	public ResponseStructure<Pilot> deletePilotById(@RequestParam int pilotById) {
		return pilotService.deletePilotById(pilotById);
	}
	
	@Operation(summary = "update pilot", description = "API is used to update the pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  pilot updated"),
			@ApiResponse(responseCode = "404", description = "pilot not found for the given id") })
	@PutMapping("/updatePilotById")
	public ResponseStructure<Pilot> updatePilotById(@RequestParam int oldPilotId,@RequestBody Pilot newPilot) {
		return pilotService.updatePilotById(oldPilotId, newPilot);
	}
	
	
	@Operation(summary = "fetch all pilot", description = "API is used to fetch all the pilot")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  pilot fetch all"),
			@ApiResponse(responseCode = "404", description = "pilot not found for the given id") })
	@GetMapping("/fetchAllPilot")
	public ResponseStructure<Pilot> fetchAllPilot() {
		return pilotService.fetchAllPilot();
	}
}
