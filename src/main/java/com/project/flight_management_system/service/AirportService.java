package com.project.flight_management_system.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.flight_management_system.dto.Airport;
import com.project.flight_management_system.dto.Flight;
import com.project.flight_management_system.exception.AirportIdNotFound;
import com.project.flight_management_system.util.ResponseStructure;
import com.project.flight_management_system.util.ResponseStructureAll;
import com.project.flight_management_system.dao.AirportDao;
@Service
public class AirportService {
	@Autowired
	AirportDao airportDao;
	
	@Autowired
	ResponseStructure<Airport> responseStructure;
	@Autowired
	ResponseStructureAll <Airport>responseStructureAll;	
	
	public ResponseStructureAll<Airport> fetchAllAirport(){
		responseStructureAll.setMessage("successfully all airport has been fetched");
		responseStructureAll.setStatusCode(HttpStatus.FOUND.value());
		responseStructureAll.setData(airportDao.fetchAllAirport());
		return responseStructureAll;
	}
	public ResponseStructure<Airport> fetchAirportById(int airportById) {
		Airport airport=airportDao.fetchAirportById(airportById);
		if(airport!=null) {
			responseStructure.setMessage("success Airport fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(airportDao.fetchAirportById(airportById));
			return responseStructure;
		}
		else {
			throw new AirportIdNotFound();
		}
		
	}
	
	public ResponseStructure<Airport> saveAirport(Airport airport) {
		responseStructure.setMessage("success Airport is Created in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(airportDao.saveAirport(airport));
		return responseStructure;
	}
	
	public ResponseStructure<Airport> deleteAirportById(int airportById) {
		Airport airport=airportDao.fetchAirportById(airportById);
		if(airport!=null) {
			responseStructure.setMessage("success Airport delete from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.deleteAirportById( airportById));
			return responseStructure;
		}
		else {
			throw new AirportIdNotFound();
		}
	}
	public ResponseStructure<Airport> updateAirportById(int oldAirportId,Airport newAirport) {
		Airport airport=airportDao.fetchAirportById(oldAirportId);
		if(airport!=null) {
			responseStructure.setMessage("success Airport updated from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(airportDao.updateAirportById( oldAirportId, newAirport));
			return responseStructure;
		}
		else {
			throw new AirportIdNotFound();
		}
	}
	
	
	public Airport addExistingAddressToExistingAirport(int addressId,int airportId) {
		return airportDao.addExistingAddressToExistingAirport(addressId, airportId);
	}
	
	public Airport addExistingFlightToExistingAirport(int flightId,int airportId) {
		return airportDao.addExistingFlightToExistingAirport(flightId, airportId);
	}
	
	public Airport addNewFlightToExistingAirport(int airportId,Flight newFlight) {
		return airportDao.addNewFlightToExistingAirport(airportId, newFlight);
	}
	
	
	
	
	
//	public Airport fetchAirportById(int airportById) {
//		return airportDao.fetchAirportById(airportById);
//	}
//	public List<Airport> fetchAllAirport() {
//		return airportDao.fetchAllAirport();
//	}
//	public Airport saveAirport(Airport airport) {
//		return airportDao.saveAirport(airport);
//	}
//	public Airport deleteAirportById(int airportById) {
//		return airportDao.deleteAirportById(airportById);
//	}
//	public Airport updateAirportById(int oldAirportId,Airport newAirport) {
//		return airportDao.updateAirportById(oldAirportId, newAirport);
//	}

}
