package com.project.flight_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.service.AddressService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
@RestController
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@Operation(summary = "Save Address", description = "API is used to save the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  Address created"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@PostMapping("/saveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	
	@Operation(summary = "fetch Address", description = "API is used to fetch the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  Address fetched"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@GetMapping("/fetchAddressById")
	public ResponseStructure<Address> fetchAddressById(@RequestParam int addressById) {
		return addressService.fetchAddressById(addressById);
	}
	
	
	@Operation(summary = "delete Address", description = "API is used to delete the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Address deleted"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@DeleteMapping("/deleteAddressById")
	public ResponseStructure<Address> deleteAddressById(@RequestParam int addressById) {
		return addressService.deleteAddressById(addressById);
	}
	
	
	@Operation(summary = "update Address", description = "API is used to update the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Address updated"),
			@ApiResponse(responseCode = "404", description = "Address not found for the given id") })
	@PutMapping("/updateAddressById")
	public ResponseStructure<Address> updateAddressById(@RequestParam int oldAddressId,@RequestBody Address newAddress) {
		return addressService.updateAddressById(oldAddressId, newAddress);
	}
	
	
	@Operation(summary = "fetch all Address", description = "API is used to fetch all the Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  Address fetch all"),
			@ApiResponse(responseCode = "404", description = "Address not found ") })
	@GetMapping("/fetchAllAddress")
	public ResponseStructureAll<Address> fetchAllAddress() {
		return addressService.fetchAllAddress();
	}
}
