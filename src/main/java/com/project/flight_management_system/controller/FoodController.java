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
import com.project.flight_management_system.service.FoodService;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
@RestController
public class FoodController {
	@Autowired
	FoodService foodService;
	
	@Operation(summary = "Save Food", description = "API is used to save the Food")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Food created"),
			@ApiResponse(responseCode = "404", description = "Food not found for the given id") })
	@PostMapping("/saveFood")
	public ResponseStructure<Food> saveFood(@RequestBody Food food) {
		return foodService.saveFood(food);
	}
	@Operation(summary = "fetch Food", description = "API is used to fetch the Food")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  Food fetched"),
			@ApiResponse(responseCode = "404", description = "Food not found for the given id") })
	@GetMapping("/fetchFoodById")
	public ResponseStructure<Food> fetchFoodById(@RequestParam int foodById) {
		return foodService.fetchFoodById(foodById);
	}
	@Operation(summary = "delete Food", description = "API is used to delete the Food")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Food deleted"),
			@ApiResponse(responseCode = "404", description = "Food not found for the given id") })
	@DeleteMapping("/deleteFoodById")
	public ResponseStructure<Food> deleteFoodById(@RequestParam int foodById) {
		return foodService.deleteFoodById(foodById);
	}
	
	@Operation(summary = "update Food", description = "API is used to update the Food")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully  Food updated"),
			@ApiResponse(responseCode = "404", description = "Food not found for the given id") })
	@PutMapping("/updateFoodById")
	public ResponseStructure<Food> updateFoodById(@RequestParam int oldFoodId,@RequestBody Food newFood) {
		return foodService.updateFoodById(oldFoodId, newFood);
	}
	@Operation(summary = "fetch all Food", description = "API is used to fetch all the Food")
	@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Successfully  Food fetch all"),
			@ApiResponse(responseCode = "404", description = "Food not found ") })
	@GetMapping("/fetchAllFood")
	public ResponseStructureAll<Food> fetchAllFood() {
		return foodService.fetchAllFood();
	}
}
