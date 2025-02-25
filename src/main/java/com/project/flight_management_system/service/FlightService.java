package com.project.flight_management_system.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dao.FlightDao;
import com.project.flight_management_system.dto.Airhostess;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.dto.Passengers;
import com.project.flight_management_system.dto.Pilot;
import com.project.flight_management_system.exception.FlightIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
@Service
public class FlightService {
	@Autowired
	FlightDao flightDao;
	@Autowired
	ResponseStructure<Flight> responseStructure;
	@Autowired
	ResponseStructureAll<Flight> responseStructureAll;
	
	public ResponseStructureAll<Flight> fetchAllFlight() {
		responseStructureAll.setMessage("successfully all Flight has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(flightDao.fetchAllFlight());
		return responseStructureAll;
	}
	public ResponseStructure<Flight> fetchFlightById(int flightById) {
		Flight flight=flightDao.deleteFlightById(flightById);
		if(flight!=null) {
			responseStructure.setMessage("success flight fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(flightDao.fetchFlightById(flightById));
			return responseStructure;
		}else {
			throw new FlightIdNotFound();
		}
		
	}
	
	public ResponseStructure<Flight> saveFlight(Flight flight) {
		responseStructure.setMessage("success flight is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(flightDao.saveFlight(flight));
		return responseStructure;
	}
	
	public ResponseStructure<Flight> deleteFlightById(int flightById) {
		Flight flight=flightDao.deleteFlightById(flightById);
		if(flight!=null) {
			responseStructure.setMessage("success flight deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(flightDao.deleteFlightById(flightById));
			return responseStructure;
		}else {
			throw new FlightIdNotFound();
		}
		
	}
	public ResponseStructure<Flight> updateFlightById(int oldFlightId,Flight newFlight) {
		Flight flight=flightDao.deleteFlightById(oldFlightId);
		if(flight!=null) {
			responseStructure.setMessage("success flight updated from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(flightDao.updateFlightById(oldFlightId, newFlight));
			return responseStructure;
		}else {
			throw new FlightIdNotFound();
		}
		
	}
	
	
	public Flight addExistingPilotToExistingFlight(int pilotId,int flightId) {
		return flightDao.addExistingPilotToExistingFlight(pilotId, flightId);
	}
	public Flight addNewPilotToExistingFlight(int flightId,Pilot newPilot) {
		return flightDao.addNewPilotToExistingFlight(flightId, newPilot);
	}
	
	public Flight addExistingAirhostessToExistingFlight(int airhostessId,int flightId) {
		return flightDao.addExistingAirhostessToExistingFlight(airhostessId, flightId);
	}
	public Flight addNewAirhostessToExistingFlight(int flightId,Airhostess newAirhostess) {
		return flightDao.addNewAirhostessToExistingFlight(flightId, newAirhostess);
	}
	public Flight addExistingPassengersToExistingFlight(int passengersId,int flightId) {
		return flightDao.addExistingPassengersToExistingFlight(passengersId, flightId);
	}
	public Flight addNewPassengersToExistingFlight(int flightId,Passengers newPassengers) {
		return flightDao.addNewPassengersToExistingFlight(flightId, newPassengers);
	}
	
//	public Flight saveFlight(Flight flight) {
//		return flightDao.saveFlight(flight);
//	}
//	public Flight fetchFlightById(int flightById) {
//		return flightDao.fetchFlightById(flightById);
//	}
//	public Flight deleteFlightById(int flightById) {
//		return flightDao.deleteFlightById(flightById);
//	}
//	public Flight updateFlightById(int oldFlightId,Flight newFlight) {
//		return flightDao.updateFlightById(oldFlightId, newFlight);
//	}
//	public List<Flight> fetchAllFlight() {
//		return flightDao.fetchAllFlight();
//	}
}
