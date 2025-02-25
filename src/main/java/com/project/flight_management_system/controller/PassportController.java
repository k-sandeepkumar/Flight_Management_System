package com.project.flight_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.service.PassportService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class PassportController {
	@Autowired
	PassportService passportService;
	@Operation(summary = "Save passport", description = "API is used to save the passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  passport created"),
			@ApiResponse(responseCode = "404", description = "passport not found for the given id") })
	@PostMapping("/savePassport")
	public ResponseStructure<Passport> savePassport(@RequestBody Passport passport) {
		return passportService.savePassport(passport);
	}
	
	@Operation(summary = "fetch passport", description = "API is used to fetch the passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  passport fetched"),
			@ApiResponse(responseCode = "404", description = "passport not found for the given id") })
	@GetMapping("/fetchPassportById")
	public ResponseStructure<Passport> fetchPassportById(@RequestParam int passportById) {
		return passportService.fetchPassportById(passportById);
	}
	@Operation(summary = "delete passport", description = "API is used to delete the passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  passport deleted"),
			@ApiResponse(responseCode = "404", description = "passport not found for the given id") })
	@DeleteMapping("/deletePassportById")
	public ResponseStructure<Passport> deletePassportById(@RequestParam int passportById) {
		return passportService.deletePassportById(passportById);
	}
	@Operation(summary = "update passport", description = "API is used to update the passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  passport updated"),
			@ApiResponse(responseCode = "404", description = "passport not found for the given id") })
	@PutMapping("/updatePassportById")
	public ResponseStructure<Passport> updatePassportById(@RequestParam int oldPassportId,@RequestBody Passport newPassport) {
		return passportService.updatePassportById(oldPassportId, newPassport);
	}
	
	@Operation(summary = "fetch all passport", description = "API is used to fetch all the passport")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  passport fetch all"),
			@ApiResponse(responseCode = "404", description = "passport not found ") })
	@GetMapping("/fetchAllPassport")
	public ResponseStructureAll<Passport> fetchAllPassport() {
		return passportService.fetchAllPassport();
	}
}
