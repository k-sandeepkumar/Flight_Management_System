package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.dto.Food;
import com.project.flight_management_system.dto.Passengers;
import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.dto.Seat;
import com.project.flight_management_system.dto.Ticket;
import com.project.flight_management_system.repo.PassengersRepo;
@Repository
public class PassengersDao {
	@Autowired
	PassengersRepo passengersRepo;
	@Autowired
	AddressDao addressDao;
	@Autowired
	SeatDao seatDao;
	@Autowired
	PassportDao passportDao;
	@Autowired
	TicketDao ticketDao;
	@Autowired
	FoodDao foodDao;
	
	public Passengers addExistingPassportToExistingPassengers(int passportId,int passengersId) {
		Passengers passengers=fetchPassengersById(passengersId);
		Passport passport=passportDao.fetchPassportById(passportId);
		passengers.setPassport(passport);
		return savePassengers(passengers);
	}
	
	public Passengers addExistingSeatToExistingPassengers(int seatId,int passengersId) {
		Passengers passengers=fetchPassengersById(passengersId);
		Seat seat=seatDao.fetchSeatById(seatId);
		passengers.setSeat(seat);
		return savePassengers(passengers);
	}
	public Passengers addExistingAddressToExistingPassengers(int addressId,int passengersId) {
		Passengers passengers=fetchPassengersById(passengersId);
		Address address=addressDao.fetchAddressById(addressId);
		passengers.setAddress(address);
		return savePassengers(passengers);
	}
	
	public Passengers addExistingTicketToExistingPassengers(int ticketId,int passengersId) {
		Passengers passengers=fetchPassengersById(passengersId);
		Ticket ticket=ticketDao.fetchTicketById(ticketId);
		List<Ticket> list=passengers.getTicket();
		list.add(ticket);
		passengers.setTicket(list);
		return savePassengers(passengers);
	}
	public Passengers addNewTicketToExistingPassengers(int passengersId,Ticket newTicket) {
		Passengers passengers =fetchPassengersById(passengersId);
		List<Ticket> list=passengers.getTicket();
		list.add(newTicket);
		passengers.setTicket(list);
		return savePassengers(passengers);
	}
	
	public Passengers addExistingFoodToExistingPassengers(int foodId,int passengersId) {
		Passengers passengers=fetchPassengersById(passengersId);
		Food food=foodDao.fetchFoodById(foodId);
		List<Food> list=passengers.getFood();
		list.add(food);
		passengers.setFood(list);
		return savePassengers(passengers);
	}
	public Passengers addNewFoodToExistingPassengers(int passengersId,Food newFood) {
		Passengers passengers =fetchPassengersById(passengersId);
		List<Food> list=passengers.getFood();
		list.add(newFood);
		passengers.setFood(list);
		return savePassengers(passengers);
	}
	
	public Passengers savePassengers(Passengers passengers) {
		return passengersRepo.save(passengers);
	}
	public Passengers fetchPassengersById(int passengersById) {
		Optional<Passengers> passengers=passengersRepo.findById(passengersById);
//		if(passengers.isPresent()) {
//			return passengers.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(passengers.isEmpty()) {
			return null;
		}
		else {
			return passengers.get();
		}
	}
	public Passengers deletePassengersById(int passengersById) {
//		Passengers passengers=passengersRepo.findById(passengersById).get();
		Passengers passengers=fetchPassengersById(passengersById);
		passengersRepo.delete(passengers);
		return passengers;
	}
	public Passengers updatePassengersById(int oldPassengersId,Passengers newPassengers) {
		newPassengers.setPassengerId(oldPassengersId);
//		return passengersRepo.save(newPassengers);
		return savePassengers(newPassengers);
	}
	public List<Passengers> fetchAllPassengers() {
		return passengersRepo.findAll();
	}
}
