package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.dto.Passengers;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.repo.FlightRepo;
@Repository
public class FlightDao {
	@Autowired
	FlightRepo flightRepo;
	@Autowired
	PilotDao pilotDao;
	@Autowired
	AirhostessDao airhostessDao;
	@Autowired
	PassengersDao passengersDao;
	
	public Flight addExistingPilotToExistingFlight(int pilotId,int flightId) {
		Flight flight =fetchFlightById(flightId);
		Pilot pilot=pilotDao.fetchPilotById(pilotId);
		List<Pilot> list=flight.getPilots();
		list.add(pilot);
		flight.setPilots(list);
		return saveFlight(flight);
	}
	public Flight addNewPilotToExistingFlight(int flightId,Pilot newPilot) {
		Flight flight =fetchFlightById(flightId);
		List<Pilot> list=flight.getPilots();
		list.add(newPilot);
		flight.setPilots(list);
		return saveFlight(flight);
	}
	
	public Flight addExistingAirhostessToExistingFlight(int airhostessId,int flightId) {
		Flight flight =fetchFlightById(flightId);
		Airhostess airhostess=airhostessDao.fetchAirhostessById(airhostessId);
		List<Airhostess> list=flight.getAirhostesses();
		list.add(airhostess);
		flight.setAirhostesses(list);
		return saveFlight(flight);
	}
	public Flight addNewAirhostessToExistingFlight(int flightId,Airhostess newAirhostess) {
		Flight flight =fetchFlightById(flightId);
		List<Airhostess> list=flight.getAirhostesses();
		list.add(newAirhostess);
		flight.setAirhostesses(list);
		return saveFlight(flight);
	}
	
	public Flight addExistingPassengersToExistingFlight(int passengersId,int flightId) {
		Flight flight =fetchFlightById(flightId);
		Passengers passengers=passengersDao.fetchPassengersById(passengersId);
		List<Passengers> list=flight.getPassengers();
		list.add(passengers);
		flight.setPassengers(list);
		return saveFlight(flight);
	}
	public Flight addNewPassengersToExistingFlight(int flightId,Passengers newPassengers) {
		Flight flight =fetchFlightById(flightId);
		List<Passengers> list=flight.getPassengers();
		list.add(newPassengers);
		flight.setPassengers(list);
		return saveFlight(flight);
	}

	
	
	
	public Flight saveFlight(Flight flight) {
		return flightRepo.save(flight);
	}
	public Flight fetchFlightById(int flightById) {
		Optional<Flight> flight=flightRepo.findById(flightById);
//		if(flight.isPresent()) {
//			return flight.get();
//		}
//		else {
//			return null;
//		}
//	}
		if(flight.isEmpty()) {
			return null;
		}
		else {
			return flight.get();
		}
	}
	public Flight deleteFlightById(int flightById) {
//		Flight flight=FlightRepo.findById(flightById).get();
		Flight flight=fetchFlightById(flightById);
		flightRepo.delete(flight);
		return flight;
	}
	public Flight updateFlightById(int oldFlightId,Flight newFlight) {
		newFlight.setFlightId(oldFlightId);
//		return FlightRepo.save(newFlight);
		return saveFlight(newFlight);
	}
	public List<Flight> fetchAllFlight() {
		return flightRepo.findAll();
	}
}
