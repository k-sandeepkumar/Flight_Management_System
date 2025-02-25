package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.repo.FoodRepo;
@Repository
public class FoodDao {
	@Autowired
	FoodRepo foodRepo;
	
	public Food saveFood(Food food) {
		return foodRepo.save(food);
	}
	public Food fetchFoodById(int foodById) {
		Optional<Food> food=foodRepo.findById(foodById);
//		if(food.isPresent()) {
//			return food.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(food.isEmpty()) {
			return null;
		}
		else {
			return food.get();
		}
	}
	public Food deleteFoodById(int foodById) {
//		Food food=FoodRepo.findById(foodById).get();
		Food food=fetchFoodById(foodById);
		foodRepo.delete(food);
		return food;
	}
	public Food updateFoodById(int oldFoodId,Food newFood) {
		newFood.setFoodId(oldFoodId);
//		return foodRepo.save(newFood);
		return saveFood(newFood);
	}
	public List<Food> fetchAllFood() {
		return foodRepo.findAll();
	}
}
