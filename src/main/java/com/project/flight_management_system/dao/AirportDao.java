package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Address;
import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.repo.AirportRepo;
@Repository
public class AirportDao {
	
	@Autowired
	AirportRepo airportRepo;
	@Autowired
	FlightDao flightDao;
	@Autowired
	AddressDao addressDao;
	
	public Airport fetchAirportById(int airportById) {
		Optional<Airport> airport=airportRepo.findById(airportById);
//		if(airport.isPresent()) {
//			return airport.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(airport.isEmpty()) {
			return null;
		}
		else {
			return airport.get();
		}
	}
	public Airport addExistingAddressToExistingAirport(int addressId,int airportId) {
		Airport airport=fetchAirportById(airportId);
		Address address=addressDao.fetchAddressById(addressId);
		airport.setAddress(address);
		return saveAirport(airport);
	}
	
	
	public Airport addExistingFlightToExistingAirport(int flightId,int airportId) {
		Airport airport =fetchAirportById(airportId);
		Flight flight=flightDao.fetchFlightById(flightId);
		List<Flight> list=airport.getFlights();
		list.add(flight);
		airport.setFlights(list);
		return saveAirport(airport);
	}
	public Airport addNewFlightToExistingAirport(int airportId,Flight newFlight) {
		Airport airport =fetchAirportById(airportId);
		List<Flight> list=airport.getFlights();
		list.add(newFlight);
		airport.setFlights(list);
		return saveAirport(airport);
	}
	
	
	public Airport saveAirport(Airport airport) {
		return airportRepo.save(airport);
	}

	public Airport deleteAirportById(int airportById) {
//		Airport airport=airportRepo.findById(airportById).get();
		Airport airport=fetchAirportById(airportById);
		airportRepo.delete(airport);
		return airport;
	}
	public Airport updateAirportById(int oldAirportId,Airport newAirport) {
		newAirport.setAirportId(oldAirportId);
//		return airportRepo.save(newAirport);
		return saveAirport(newAirport);
	}
	public List<Airport> fetchAllAirport() {
		return airportRepo.findAll();
	}
	
//	public Airport fetchAirportById(int airportById) {
//		return airportRepo.findById(airportById).get();
//	}
}
