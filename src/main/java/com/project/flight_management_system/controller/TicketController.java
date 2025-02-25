package com.project.flight_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.service.TicketService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class TicketController {
	@Autowired
	TicketService ticketService;
	@Operation(summary = "Save ticket", description = "API is used to save the ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  ticket created"),
			@ApiResponse(responseCode = "404", description = "ticket not found for the given id") })
	@PostMapping("/saveTicket")
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {
		return ticketService.saveTicket(ticket);
	}
	
	@Operation(summary = "fetch ticket", description = "API is used to fetch the ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  ticket fetched"),
			@ApiResponse(responseCode = "404", description = "ticket not found for the given id") })
	@GetMapping("/fetchTicketById")
	public ResponseStructure<Ticket> fetchTicketById(@RequestParam int ticketById) {
		return ticketService.fetchTicketById(ticketById);
	}
	
	@Operation(summary = "delete ticket", description = "API is used to delete the ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  ticket deleted"),
			@ApiResponse(responseCode = "404", description = "ticket not found for the given id") })
	@DeleteMapping("/deleteTicketById")
	public ResponseStructure<Ticket> deleteTicketById(@RequestParam int ticketById) {
		return ticketService.deleteTicketById(ticketById);
	}
	
	@Operation(summary = "update ticket", description = "API is used to update the ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  ticket updated"),
			@ApiResponse(responseCode = "404", description = "ticket not found for the given id") })
	@PutMapping("/updateTicketById")
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTicketId,@RequestBody Ticket newTicket) {
		return ticketService.updateTicketById(oldTicketId, newTicket);
	}
	
	@Operation(summary = "fetch all ticket", description = "API is used to fetch all the ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  ticket fetch all"),
			@ApiResponse(responseCode = "404", description = "ticket not found") })
	@GetMapping("/fetchAllTicket")
	public ResponseStructureAll<Ticket> fetchAllTicket() {
		return ticketService.fetchAllTicket();
	}
}
