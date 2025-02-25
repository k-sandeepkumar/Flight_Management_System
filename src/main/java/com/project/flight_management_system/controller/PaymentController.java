package com.project.flight_management_system.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.flight_management_system.dto.Payment;
import com.project.flight_management_system.service.PaymentService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	@PutMapping("/addExistingticketToExistingPayment")
	public Payment addExistingticketToExistingPayment(@RequestParam int ticketId,@RequestParam int paymentId) {
		return paymentService.addExistingticketToExistingPayment(ticketId, paymentId);
	}
	
	
	@Operation(summary = "Save payment", description = "API is used to save the payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully  payment created"),
			@ApiResponse(responseCode = "404", description = "payment not found for the given id") })
	@PostMapping("/savePayment")
	public ResponseStructure<Payment> savePayment(@RequestBody Payment payment) {
		return paymentService.savePayment(payment);
	}
	
	@Operation(summary = "fetch payment", description = "API is used to fetch the payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  payment fetched"),
			@ApiResponse(responseCode = "404", description = "payment not found for the given id") })
	@GetMapping("/fetchPaymentById")
	public ResponseStructure<Payment> fetchPaymentById(@RequestParam int paymentById) {
		return paymentService.fetchPaymentById(paymentById);
	}
	
	@Operation(summary = "delete payment", description = "API is used to delete the payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  payment deleted"),
			@ApiResponse(responseCode = "404", description = "payment not found for the given id") })
	@DeleteMapping("/deletePaymentById")
	public ResponseStructure<Payment> deletePaymentById(@RequestParam int paymentById) {
		return paymentService.deletePaymentById(paymentById);
	}
	
	
	@Operation(summary = "update payment", description = "API is used to update the payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  payment updated"),
			@ApiResponse(responseCode = "404", description = "payment not found for the given id") })
	@PutMapping("/updatePaymentById")
	public ResponseStructure<Payment> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {
		return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}
	
	@Operation(summary = "fetch all payment", description = "API is used to fetch all the payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  payment fetch all"),
			@ApiResponse(responseCode = "404", description = "payment not found ") })
	@GetMapping("/fetchAllPayment")
	public ResponseStructureAll<Payment> fetchAllPayment() {
		return paymentService.fetchAllPayment();
	}
}
