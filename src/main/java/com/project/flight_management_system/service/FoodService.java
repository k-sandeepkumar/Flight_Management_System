package com.project.flight_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.FoodDao;
import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.exception.FoodIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class FoodService {
	@Autowired
	FoodDao foodDao;
	@Autowired
	ResponseStructure<Food> responseStructure;
	@Autowired
	ResponseStructureAll<Food> responseStructureAll;
	
	public ResponseStructureAll<Food> fetchAllFood() {
		responseStructureAll.setMessage("sucessfully Food has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(foodDao.fetchAllFood());
		return responseStructureAll;
	}
	public ResponseStructure<Food> fetchFoodById(int foodById) {
		Food food=foodDao.fetchFoodById(foodById);
		if(food!=null) {
			responseStructure.setMessage("success Food fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(foodDao.fetchFoodById(foodById));
			return responseStructure;
		}
		else {
			throw new FoodIdNotFound();
		}
		
	}
	
	
	public ResponseStructure<Food> saveFood(Food food) {
		responseStructure.setMessage("success Airport is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(foodDao.saveFood(food));
		return responseStructure;
	}
	
	public ResponseStructure<Food> deleteFoodById(int foodById) {
		Food food=foodDao.fetchFoodById(foodById);
		if(food!=null) {
			responseStructure.setMessage("success Food deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(foodDao.deleteFoodById(foodById));
			return responseStructure;
		}
		else {
			throw new FoodIdNotFound();
		}
	}
	public ResponseStructure<Food> updateFoodById(int oldFoodId,Food newFood) {
		Food food=foodDao.fetchFoodById(oldFoodId);
		if(food!=null) {
			responseStructure.setMessage("success Food fetched from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(foodDao.updateFoodById(oldFoodId, newFood));
			return responseStructure;
		}
		else {
			throw new FoodIdNotFound();
		}
		
	}
	
//	public Food saveFood(Food food) {
//		return foodDao.saveFood(food);
//	}
//	public Food fetchFoodById(int foodById) {
//		return foodDao.fetchFoodById(foodById);
//	}
//	public Food deleteFoodById(int foodById) {
//		return foodDao.deleteFoodById(foodById);
//	}
//	public Food updateFoodById(int oldFoodId,Food newFood) {
//		return foodDao.updateFoodById(oldFoodId, newFood);
//	}
//	public List<Food> fetchAllFood() {
//		return foodDao.fetchAllFood();
//	}
}
