package com.project.flight_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.PassengersDao;
import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.dto.Passengers;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.exception.PassengersIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class PassengersService {
	@Autowired
	PassengersDao passengersDao;
	@Autowired
	ResponseStructure<Passengers> responseStructure;
	@Autowired
	ResponseStructureAll<Passengers> responseStructureAll;
	
	public ResponseStructureAll<Passengers> fetchAllPassengers() {
		responseStructureAll.setMessage("sucessfully Passengers has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(passengersDao.fetchAllPassengers());
		return responseStructureAll;
	}
	public ResponseStructure<Passengers> fetchPassengersById(int passengersById) {
		Passengers passengers=passengersDao.fetchPassengersById(passengersById);
		if(passengers!=null) {
			responseStructure.setMessage("success Passengers fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(passengersDao.fetchPassengersById(passengersById));
			return responseStructure;
		}else {
			throw new PassengersIdNotFound();
		}
	}
	public ResponseStructure<Passengers> savePassengers(Passengers passengers) {
		responseStructure.setMessage("success Passengers is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(passengersDao.savePassengers(passengers));
		return responseStructure;
	}
	
	public ResponseStructure<Passengers> deletePassengersById(int passengersById) {
		Passengers passengers=passengersDao.fetchPassengersById(passengersById);
		if(passengers!=null) {
			responseStructure.setMessage("success Passengers deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(passengersDao.deletePassengersById(passengersById));
			return responseStructure;
		}else {
			throw new PassengersIdNotFound();
		}
	
	}
	public ResponseStructure<Passengers> updatePassengersById(int oldPassengersId,Passengers newPassengers) {
		Passengers passengers=passengersDao.fetchPassengersById(oldPassengersId);
		if(passengers!=null) {
			responseStructure.setMessage("success Passengers updated from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(passengersDao.updatePassengersById(oldPassengersId, newPassengers));
			return responseStructure;
		}else {
			throw new PassengersIdNotFound();
		}

	}
	
	
	
	public Passengers addExistingPassportToExistingPassengers(int passportId,int passengersId) {
		return passengersDao.addExistingPassportToExistingPassengers(passportId, passengersId);
	}
	
	public Passengers addExistingSeatToExistingPassengers(int seatId,int passengersId) {
		return passengersDao.addExistingSeatToExistingPassengers(seatId, passengersId);
	}
	public Passengers addExistingAddressToExistingPassengers(int addressId,int passengersId) {
		return passengersDao.addExistingAddressToExistingPassengers(addressId, passengersId);
	}
	
	public Passengers addExistingTicketToExistingPassengers(int ticketId,int passengersId) {
		return passengersDao.addExistingTicketToExistingPassengers(ticketId, passengersId);
	}
	public Passengers addNewTicketToExistingPassengers(int passengersId,Ticket newTicket) {
		return passengersDao.addNewTicketToExistingPassengers(passengersId, newTicket);
	}
	
	public Passengers addExistingFoodToExistingPassengers(int foodId,int passengersId) {
		return passengersDao.addExistingFoodToExistingPassengers(foodId, passengersId);
	}
	public Passengers addNewFoodToExistingPassengers(int passengersId,Food newFood) {
		return passengersDao.addNewFoodToExistingPassengers(passengersId, newFood);
	}
	
//	public Passengers savePassengers(Passengers passengers) {
//		return passengersDao.savePassengers(passengers);
//	}
//	public Passengers fetchPassengersById(int passengersById) {
//		return passengersDao.fetchPassengersById(passengersById);
//	}
//	public Passengers deletePassengersById(int passengersById) {
//		return passengersDao.deletePassengersById(passengersById);
//	}
//	public Passengers updatePassengersById(int oldPassengersId,Passengers newPassengers) {
//		return passengersDao.updatePassengersById(oldPassengersId, newPassengers);
//	}
//	public List<Passengers> fetchAllPassengers() {
//		return passengersDao.fetchAllPassengers();
//	}
}
